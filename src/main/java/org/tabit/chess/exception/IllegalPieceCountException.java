package org.tabit.chess.exception;

public class IllegalPieceCountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 143534534L;
	
	public IllegalPieceCountException(){
		
	}
	
	public IllegalPieceCountException(String message){
		super(message);
	}

}
