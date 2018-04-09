package org.tabit.chess.domain;

public class Piece {
    public PieceType type;
    public Color color;
    
    public Piece(PieceType type, Color color){
    	this.type = type;
    	this.color = color;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Piece)) {
            return false;
        }
        Piece otherPiece = (Piece) object;
        return this.type == otherPiece.type
                && this.color == otherPiece.color;
    }
    
    @Override
    public int hashCode() {
        int colorMarker = color == Color.WHITE ? 0 : 6;
        int pieceTypeMarker = 0;
        switch (type) {
            case PAWN:
                pieceTypeMarker = 0;
                break;
            case ROOK:
                pieceTypeMarker = 1;
                break;
            case BISHOP:
                pieceTypeMarker = 2;
                break;
            case KNIGHT:
                pieceTypeMarker = 3;
                break;
            case KING:
                pieceTypeMarker = 4;
                break;
            case QUEEN:
                pieceTypeMarker = 5;
                break;
        }
        return (pieceTypeMarker + colorMarker);
    }
}
