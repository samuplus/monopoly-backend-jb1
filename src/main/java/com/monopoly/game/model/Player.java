package com.monopoly.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("PLAYER")
public class Player {
  @Id
  @Column("PLAYER_ID")
  private Long playerId;

  @Column("PLAYER_NAME")
  private String playerName;

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
