package com.monopoly.game.service;

import com.monopoly.game.model.Player;
import com.monopoly.game.repository.PlayerRepository;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Math.round;

@Service
@AllArgsConstructor
public class PlayerService {

  @Autowired
  private PlayerRepository playerRepository;

  public List<Player> getAllPlayerData() {
    List<Player> playerList = (List<Player>) playerRepository.findAll();
    return playerList;
  }

  public Player getPlayerById(Long playerId){
    Player player = playerRepository.findById(playerId);
    return player;
  }


  public Player createNewPlayer(Player player){
    return playerRepository.save(player);
  }

  public void deletePlayerById(Long playerId){
    Player player = playerRepository.findById(playerId);
    playerRepository.delete(player);
  }

  public Player updatePlayer(Long playerId, Player player){
    Player existingPlayer = playerRepository.findById(playerId);
    BeanUtils.copyProperties(player, existingPlayer, "playerId", "playerName", "playerColour");
    return playerRepository.save(existingPlayer);
  }

  public Player updatePlayerDetails(Long playerId, Player player){
    Player existingPlayer = playerRepository.findById(playerId);
    BeanUtils.copyProperties(player, existingPlayer, "playerId", "playerBoardPosition", "playerBalance");
    return playerRepository.save(existingPlayer);
  }

  public Player updatePlayerColour(Long playerId, String playerColour){
    Player existingPlayer = playerRepository.findById(playerId);
    existingPlayer.setPlayerColour(playerColour);
    return playerRepository.save(existingPlayer);
  }

  public int getDiceValue(long playerId) {
    Player existingPlayer = playerRepository.findById(playerId);
    long randomNumber = Math.round(Math.random()*11+1);
    long position = existingPlayer.getPlayerBoardPosition();
    position += randomNumber;
    existingPlayer.setPlayerBoardPosition(position);
    playerRepository.save(existingPlayer);
   return (int) randomNumber;
  }
}
//  Develop the backend of the following user story: As a player, I want to roll two dice and see the output so that I know how many positions I will advance.
//        Hint: a new endpoint is required as well as its implementation

//get result of getDiceValue and *100