package com.monopoly.game.repository;

import com.monopoly.game.model.Player;
import com.monopoly.game.util.QueryConstants;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends CrudRepository<Player,Integer> {

  @Query(value = QueryConstants.GET_PLAYER_BY_ID)
  public Player findById(Long playerId);
}
