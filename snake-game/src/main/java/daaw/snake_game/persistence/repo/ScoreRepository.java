package daaw.snake_game.persistence.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import daaw.snake_game.persistence.model.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
    List<Score> findByPlayerName(String playerName);

    @Query(value = "SELECT * FROM score ORDER BY score DESC LIMIT :limit", nativeQuery = true)
    List<Score> findTopScores(@Param("limit") int limit);

}