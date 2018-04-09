package org.tabit.chess.domain;

import org.tabit.chess.exception.IllegalPieceCountException;
import org.tabit.chess.exception.WrongPieceException;

public class ChessBoard {
	public static final int BOARD_SIZE = 8;
	
    private int[][] counter = new int[8][2];
	
	private Piece[][] squares = new Piece[BOARD_SIZE][BOARD_SIZE];
	
	public void putPieceAtPosition(Piece piece, Position position) throws IllegalPieceCountException, WrongPieceException {
		if(piece == null) {
			throw new WrongPieceException();
		}
		int count = counter[piece.type.ordinal()][piece.color.ordinal()];
		if(count+1 > piece.type.maxAllowed) {
			throw new IllegalPieceCountException();
		}
		counter[piece.type.ordinal()][piece.color.ordinal()]++;
        squares[position.row][position.column] = piece;
    }

    public Piece getPieceAtPosition(Position position) {
    	
        return squares[position.row][position.column];
    }
    
    public static ChessBoard createNewBoard() throws IllegalPieceCountException, WrongPieceException {
    	
    	ChessBoard board = new ChessBoard();
    	board.putPieceAtPosition(new Piece(PieceType.ROOK, Color.BLACK),   new Position(0, 0));
    	board.putPieceAtPosition(new Piece(PieceType.KNIGHT, Color.BLACK), new Position(0, 1));
    	board.putPieceAtPosition(new Piece(PieceType.BISHOP, Color.BLACK), new Position(0, 2));
    	board.putPieceAtPosition(new Piece(PieceType.QUEEN, Color.BLACK),  new Position(0, 3));
    	board.putPieceAtPosition(new Piece(PieceType.KING, Color.BLACK),  new Position( 0, 4));
    	board.putPieceAtPosition(new Piece(PieceType.BISHOP, Color.BLACK),new Position( 0, 5));
    	board.putPieceAtPosition(new Piece(PieceType.KNIGHT, Color.BLACK),new Position( 0, 6));
    	board.putPieceAtPosition(new Piece(PieceType.ROOK, Color.BLACK),  new Position( 0, 7));
    	for(int i=0;i<8;i++) {
    		board.putPieceAtPosition(new Piece(PieceType.PAWN, Color.BLACK),  new Position( 1, i));
    	}
    	board.putPieceAtPosition(new Piece(PieceType.ROOK,  Color.WHITE),  new Position(7, 0));
    	board.putPieceAtPosition(new Piece(PieceType.KNIGHT, Color.WHITE), new Position(7, 1));
    	board.putPieceAtPosition(new Piece(PieceType.BISHOP, Color.WHITE), new Position(7, 2));
    	board.putPieceAtPosition(new Piece(PieceType.QUEEN, Color.WHITE),  new Position(7, 3));
    	board.putPieceAtPosition(new Piece(PieceType.KING, Color.WHITE),  new Position( 7, 4));
    	board.putPieceAtPosition(new Piece(PieceType.BISHOP, Color.WHITE),new Position( 7, 5));
    	board.putPieceAtPosition(new Piece(PieceType.KNIGHT, Color.WHITE),new Position( 7, 6));
    	board.putPieceAtPosition(new Piece(PieceType.ROOK, Color.WHITE),  new Position( 7, 7));  
    	for(int i=0;i<8;i++) {
    		board.putPieceAtPosition(new Piece(PieceType.PAWN, Color.WHITE),  new Position( 6, i));
    	}
    	return board;
    	
    }
}
