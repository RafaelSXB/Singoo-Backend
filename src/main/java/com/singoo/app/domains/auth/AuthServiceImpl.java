
package com.singoo.app.domains.auth;
import com.singoo.app.Security.JwtTokenProvider;
import com.singoo.app.domains.auth.AuthResponseDTO;
import com.singoo.app.domains.auth.LoginRequestDTO;
import com.singoo.app.domains.auth.RegisterRequestDTO;
import com.singoo.app.domains.auth.User;
import com.singoo.app.domains.auth.UserRepository;
import com.singoo.app.domains.auth.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthServiceInterface {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
                           PasswordEncoder passwordEncoder, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public AuthResponseDTO register(RegisterRequestDTO request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Este e-mail já está em uso!");
        }

        User user = new User(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );

        User savedUser = userRepository.save(user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);


        AuthResponseDTO.UserDto userDto = new AuthResponseDTO.UserDto(savedUser.getId(), savedUser.getEmail(), savedUser.getTier());
        return new AuthResponseDTO(jwt, userDto);
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = tokenProvider.generateToken(authentication);

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado após autenticação"));

        AuthResponseDTO.UserDto userDto = new AuthResponseDTO.UserDto(user.getId(), user.getEmail(), user.getTier());
        return new AuthResponseDTO(jwt, userDto);
    }
}