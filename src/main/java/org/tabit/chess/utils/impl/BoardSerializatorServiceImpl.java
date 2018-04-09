package org.tabit.chess.utils.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.tabit.chess.domain.ChessBoard;
import org.tabit.chess.domain.Color;
import org.tabit.chess.domain.Piece;
import org.tabit.chess.domain.PieceType;
import org.tabit.chess.domain.Position;
import org.tabit.chess.exception.IllegalPieceCountException;
import org.tabit.chess.exception.WrongPieceException;
import org.tabit.chess.utils.BoardSerializatorService;

public class BoardSerializatorServiceImpl implements BoardSerializatorService {

	@Override
	public ChessBoard load(String fileName) throws WrongPieceException, IOException, IllegalPieceCountException {
		File file = new File(fileName);
		ChessBoard board = new ChessBoard();
		FileReader fileReader = new FileReader(file.getPath());
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		int row = 0;
		while ((line = bufferedReader.readLine()) != null) {
			String[] columns = line.split("\\|");
			for (int k = 1; k <= 8; k++) {
				Position position = new Position(row, k - 1);
				switch (columns[k]) {
				case "ro":
					board.putPieceAtPosition(new Piece(PieceType.ROOK, Color.WHITE), position);
					break;
				case "kn":
					board.putPieceAtPosition(new Piece(PieceType.KNIGHT, Color.WHITE), position);
					break;
				case "bi":
					board.putPieceAtPosition(new Piece(PieceType.BISHOP, Color.WHITE), position);
					break;
				case "qu":
					board.putPieceAtPosition(new Piece(PieceType.QUEEN, Color.WHITE), position);
					break;
				case "ki":
					board.putPieceAtPosition(new Piece(PieceType.KING, Color.WHITE), position);
					break;
				case "pa":
					board.putPieceAtPosition(new Piece(PieceType.PAWN, Color.WHITE), position);
					break;
				case "oɹ":
					board.putPieceAtPosition(new Piece(PieceType.ROOK, Color.BLACK), position);
					break;
				case "uʞ":
					board.putPieceAtPosition(new Piece(PieceType.KNIGHT, Color.BLACK), position);
					break;
				case "ıq":
					board.putPieceAtPosition(new Piece(PieceType.BISHOP, Color.BLACK), position);
					break;
				case "nb":
					board.putPieceAtPosition(new Piece(PieceType.QUEEN, Color.BLACK), position);
					break;
				case "ıʞ":
					board.putPieceAtPosition(new Piece(PieceType.KING, Color.BLACK), position);
					break;
				case "ɐd":
					board.putPieceAtPosition(new Piece(PieceType.PAWN, Color.BLACK), position);
					break;
				case "  ": break;	
				default:
					throw new WrongPieceException(columns[k], position);
				}
			}
			if(row++>=7) break;			
		}
	    fileReader.close();
		bufferedReader.close();
		return board;
	}
	
	private String getPresentation(Piece piece) {
		if(piece==null) {
			return "  ";
		}
		if(piece.color == Color.BLACK) {
			switch(piece.type) {
				case PAWN: return "ɐd";
				case KING: return "ıʞ";
				case QUEEN: return "nb";
				case BISHOP: return "ıq";
				case KNIGHT: return "uʞ";
				case ROOK: return "oɹ";
				default: return "  ";
			}
		}
		else {
			switch(piece.type) {
				case PAWN: return "pa";
				case KING: return "ki";
				case QUEEN: return "qu";
				case BISHOP: return "bi";
				case KNIGHT: return "kn";
				case ROOK: return "ro";
				default: return "  ";
			}		
		}
	}

	@Override
	public void save(ChessBoard chessBoard, String fileName) throws IOException {
		
		File file = new File(fileName);
		FileWriter fileReader = new FileWriter(file.getPath());
		BufferedWriter bufferedReader = new BufferedWriter(fileReader);
		for(int i=0; i<8; i++) {
			StringBuilder sb = new StringBuilder(26);
			sb.append("" + (8-i) + " |");		
			for(int j=0; j<8; j++) {
				sb.append(getPresentation(chessBoard.getPieceAtPosition(new Position(i, j)))+"|");
			}
			bufferedReader.write(sb.toString());
			bufferedReader.newLine();		
		}		
		bufferedReader.write("   a  b  c  d  e  f  g  h");
		bufferedReader.flush();
		bufferedReader.close();
		fileReader.close();	
	}

}
