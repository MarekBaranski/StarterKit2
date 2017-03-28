package com.capgemini.chess.exception;

public class ChessException extends Exception {
    
    public static String PROFILENOTFOUND = "Brak profilu o takim id";
    public static String MATCHNOTFOUND = "Brak meczu o takim id";
    
   
    private static final long serialVersionUID = 1L;

    public ChessException(String message){
          super(message);
    }

}
