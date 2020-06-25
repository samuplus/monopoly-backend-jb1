package com.monopoly.game.controller;

import com.monopoly.game.model.Player;
import com.monopoly.game.service.PlayerService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/players")
public class PlayerController {

  @Autowired
  private PlayerService playerService;

  /**
   * Get all players
   *
   * @return
   */
  @GetMapping
  public List<Player> getallPlayers() {
    return playerService.getAllPlayerData();
  }

  @GetMapping("/{playerId}")
  public Player getPlayerById(@PathVariable("playerId") Long playerId) {
    return playerService.getPlayerById(playerId);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.CREATED)
  public Player createNewPlayer(@Valid @RequestBody Player player) {
    return playerService.createNewPlayer(player);
  }

  @DeleteMapping("/{playerId}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deletePlayerById(@PathVariable("playerId") Long playerId) {
    playerService.deletePlayerById(playerId);
  }

  @PatchMapping("/{playerId}/position")
  public Player updatePlayer(@PathVariable("playerId") Long playerId, @RequestBody Player player) {
    return playerService.updatePlayer(playerId, player);
  }

  @PatchMapping("/{playerId}/details")
  public Player updatePlayerDetails(@PathVariable("playerId") Long playerId, @RequestBody Player player) {
    return playerService.updatePlayerDetails(playerId, player);
  }

  @PatchMapping("/{playerId}/colour/{playerColour}")
  public Player updatePlayerColour(@PathVariable("playerId") Long playerId, @PathVariable("playerColour") String playerColour) {
    return playerService.updatePlayerColour(playerId, playerColour);
  }

  @GetMapping("/{playerId}/diceValue")
  public long getDiceValue(@PathVariable("playerId") Long playerId){
    return playerService.getDiceValue(playerId);
  }
}

//Develop the backend of the following user story: As a player, I want to be able to edit my name and colour so that I correct misspellings or choose a different colour.
//Hint: a new endpoint will be required since the request comes from the user (frontend)

//  Develop the backend of the following user story: As a player, I want to roll two dice and see the output so that I know how many positions I will advance.
//        Hint: a new endpoint is required as well as its implementation