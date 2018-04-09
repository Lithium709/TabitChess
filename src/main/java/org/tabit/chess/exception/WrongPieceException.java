package org.tabit.chess.exception;

import org.tabit.chess.domain.Position;

public class WrongPieceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongPieceException() {
	}
	
	public WrongPieceException(String message, Position position) {
	    super("Wrong piece at position [" + position.column + " " + position.row + "] " + message);
	}

}
