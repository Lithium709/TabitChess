package org.tabit.chess.domain;

public enum PieceType {
	PAWN(8),
    ROOK(2),
    KNIGHT(2),
    BISHOP(2),
    QUEEN(1),
    KING(1);
    public int maxAllowed;
	PieceType(int max){
		this.maxAllowed = max;
	}
}
