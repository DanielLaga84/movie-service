package com.infoshare.movieservice.service;

import com.infoshare.movieservice.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final List<Player> players = new ArrayList<>();

    public PlayerService() {
        players.add(new Player(1L, "Borucznik", "Porewicz"));
        players.add(new Player(2L, "Robert", "Lewandowski"));
    }

    public Optional<Player> findById(Long id) {
        return players.stream()
                      .filter(player -> player.getId().equals(id))
                      .findFirst();
    }

}
