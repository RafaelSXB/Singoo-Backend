package com.singoo.app.domains.community.service;

import com.singoo.app.domains.auth.User;
import com.singoo.app.domains.auth.UserRepository;
import com.singoo.app.domains.community.dto.SongRequestDto;
import com.singoo.app.domains.community.dto.SongRequestResponse;
import com.singoo.app.domains.community.model.SongRequest;
import com.singoo.app.domains.community.repository.SongRequestRepository;
import com.singoo.app.Security.exception.custom.ResourceNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SongRequestImpl implements SongRequestInterface {

    private final SongRequestRepository songRequestRepository;
    private final UserRepository userRepository;
    
    private static final int POINTS_FOR_REQUEST = 10;

    public SongRequestImpl(SongRequestRepository songRequestRepository, UserRepository userRepository) {
        this.songRequestRepository = songRequestRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public SongRequestResponse submitSongRequest(SongRequestDto requestDto) {
        
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador não encontrado."));

        SongRequest newRequest = new SongRequest(
                user, 
                requestDto.getSongName(), 
                requestDto.getArtistName()
        );
        songRequestRepository.save(newRequest);

        int currentPoints = user.getTotalPoints() != null ? user.getTotalPoints() : 0;
        user.setTotalPoints(currentPoints + POINTS_FOR_REQUEST);
        userRepository.save(user);

        return new SongRequestResponse("Pedido recebido com sucesso!", POINTS_FOR_REQUEST);
    }
}