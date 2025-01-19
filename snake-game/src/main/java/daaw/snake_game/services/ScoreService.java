package daaw.snake_game.services;

import daaw.snake_game.persistence.model.Score;
import daaw.snake_game.persistence.repo.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getScoresByPlayerName(String playerName) {
        return scoreRepository.findByPlayerName(playerName);
    }

    public List<Score> getTopScores(int limit) {
        return scoreRepository.findTopScores(limit);
    }

    public Score createNewScore(String playerName, int score) {
        Score newScore = new Score();
        newScore.setPlayerName(playerName);
        newScore.setScore(score);

        return scoreRepository.save(newScore);
    }

}
