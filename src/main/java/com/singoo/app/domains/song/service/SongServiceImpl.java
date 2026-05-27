package com.singoo.app.domains.song.service;

import com.singoo.app.common.dto.PaginatedResponse;
import com.singoo.app.domains.song.dto.LyricDto;
import com.singoo.app.domains.song.dto.SongDetailsDto;
import com.singoo.app.domains.song.dto.SongListDto;
import com.singoo.app.domains.song.model.Song;
import com.singoo.app.domains.song.model.SongLyric;
import com.singoo.app.domains.song.repository.SongLyricRepository;
import com.singoo.app.domains.song.repository.SongRepository;
import com.singoo.app.domains.song.service.SongServiceInterface;
import com.singoo.app.Security.exception.custom.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongServiceInterface {

    private final SongRepository songRepository;
    private final SongLyricRepository songLyricRepository;

    public SongServiceImpl(SongRepository songRepository, SongLyricRepository songLyricRepository) {
        this.songRepository = songRepository;
        this.songLyricRepository = songLyricRepository;
    }

    @Override
    public PaginatedResponse<SongListDto> getCatalog(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Song> songPage;
    
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            System.out.println(searchTerm);
            songPage = songRepository.findByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(searchTerm, searchTerm, pageable);
        } else {
             System.out.println(searchTerm);
            songPage = songRepository.findAll(pageable);
        }

 
        List<SongListDto> content = songPage.getContent().stream()
                .map(song -> new SongListDto(
                        song.getId(),
                        song.getTitle(),
                        song.getArtist(),
                        song.getYoutubeVideoId(),
                        song.getDifficulty(),
                        song.getTierRequired()
                ))
                .collect(Collectors.toList());

 
        return new PaginatedResponse<>(
                content,
                songPage.getTotalElements(),
                songPage.getTotalPages()
        );
    }

    @Override
    public SongDetailsDto getSongDetails(UUID songId) {
 
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada no catálogo."));

  
        List<SongLyric> lyrics = songLyricRepository.findBySongIdOrderByStartTimeMsAsc(songId);

  
        List<LyricDto> lyricDtos = lyrics.stream()
                .map(lyric -> new LyricDto(
                        lyric.getStartTimeMs(),
                        lyric.getEndTimeMs(),
                        lyric.getEnglishPhrase(),
                        lyric.getPortugueseTranslation()
                ))
                .collect(Collectors.toList());

       
        return new SongDetailsDto(song.getId(), song.getYoutubeVideoId(), lyricDtos);
    }
}