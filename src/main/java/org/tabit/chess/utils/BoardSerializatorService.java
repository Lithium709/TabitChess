package org.tabit.chess.utils;

import java.io.IOException;

import org.tabit.chess.domain.ChessBoard;
import org.tabit.chess.exception.IllegalPieceCountException;
import org.tabit.chess.exception.WrongPieceException;

public interface BoardSerializatorService {
	
	public ChessBoard load(String fileName) throws WrongPieceException, IOException, IllegalPieceCountException;
	
	public void save(ChessBoard chessBoard, String fileName) throws IOException;

}
