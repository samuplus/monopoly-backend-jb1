package com.monopoly.game.model;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("PLAYER")
public class Player {

  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public String getPlayerColour() {
    return playerColour;
  }

  public void setPlayerColour(String playerColour) {
    this.playerColour = playerColour;
  }

  public Long getPlayerBalance() {
    return playerBalance;
  }

  public void setPlayerBalance(Long playerBalance) {
    this.playerBalance = playerBalance;
  }

  public Long getPlayerBoardPosition() {
    return playerBoardPosition;
  }

  public void setPlayerBoardPosition(Long playerBoardPosition) {
    this.playerBoardPosition = playerBoardPosition;
  }

  @Id
  @Column("PLAYER_ID")
  private Long playerId;

  @Column("PLAYER_NAME")
  @NotBlank(message = "Name is mandatory")
  private String playerName;

  @NotBlank(message = "Colour is mandatory")
  @Column("PLAYER_COLOUR")
  private String playerColour;

  @Column("PLAYER_BALANCE")
  private Long playerBalance;

  @Column("PLAYER_BOARD_POSITION")
  private Long playerBoardPosition;

  @Override
  public String toString() {
    return "Player {" +
        "id = " + playerId + "\n" +
        "name = " + playerName + "\n" +
        "colour = " + playerColour + "\n" +
        "balance = " + playerBalance + "\n" +
        "position = " + playerBoardPosition + "\n" +
        "}";
  }
}
