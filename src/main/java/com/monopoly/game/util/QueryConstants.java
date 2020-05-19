package com.monopoly.game.util;

public class QueryConstants {

  private QueryConstants() {}

  public static final String GET_PLAYER_BY_ID = "SELECT * FROM PLAYER WHERE PLAYER_ID= :playerId";

}
