package com.monoply.game.service;

import com.monoply.game.entity.Game;
import com.monoply.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public Game createNewGame(Game game) {
        return gameRepository.save(game);
    }

    @Transactional(readOnly = true)
    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public boolean gameExists(Long id) {
        return gameRepository.existsById(id);
    }

    @Transactional
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
