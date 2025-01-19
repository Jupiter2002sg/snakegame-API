package daaw.snake_game.controllers;

import daaw.snake_game.persistence.model.Score;
import daaw.snake_game.services.ScoreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    // POST: Añadir un nuevo Score
    @PostMapping("/create")
    public Score createNewScore(@RequestBody Map<String, Object> requestBody) {
        String playerName = (String) requestBody.get("playerName");
        int score = (int) requestBody.get("score");

        return scoreService.createNewScore(playerName, score);
    }

    // GET: Obtener el score de un jugador específico
    @GetMapping("/{playerName}")
    public List<Integer> getScoresByPlayerName(@PathVariable String playerName) {
        // Transformar la lista de objetos Score en una lista de enteros (solo scores)
        return scoreService.getScoresByPlayerName(playerName)
                .stream()
                .map(Score::getScore)
                .toList();
    }

    // GET: Obtener el ranking de los mejores scores
    @GetMapping("/ranking")
    public List<Score> getRanking(@RequestParam(defaultValue = "5") int limit) {
        return scoreService.getTopScores(limit);
    }
}
