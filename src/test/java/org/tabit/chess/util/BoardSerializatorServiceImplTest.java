package org.tabit.chess.util;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Files;
import org.junit.Test;
import org.tabit.chess.domain.ChessBoard;
import org.tabit.chess.domain.Color;
import org.tabit.chess.domain.Piece;
import org.tabit.chess.domain.PieceType;
import org.tabit.chess.domain.Position;
import org.tabit.chess.exception.IllegalPieceCountException;
import org.tabit.chess.exception.WrongPieceException;
import org.tabit.chess.utils.impl.BoardSerializatorServiceImpl;


public class BoardSerializatorServiceImplTest {

	private static String createTempFile() throws IOException {
        Path path = Files.createTempFile("sample-file", ".txt");
        File file = path.toFile();
        file.deleteOnExit();
        return file.getAbsolutePath();
    }
	
	boolean compareFiles(String file1, String file2) {
		StringBuilder original = new StringBuilder();
		try(FileInputStream fin =  new FileInputStream(file1);		
		    BufferedReader myInput1 = new BufferedReader(new InputStreamReader(fin))){
		String thisLine;
			while ((thisLine = myInput1.readLine()) != null) {  
				original.append(thisLine);
			  }	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringBuilder saved = new StringBuilder();
		try(FileInputStream fin =  new FileInputStream(file2);		
			BufferedReader myInput1 = new BufferedReader(new InputStreamReader(fin))){
		String thisLine;
			while ((thisLine = myInput1.readLine()) != null) {  
				saved.append(thisLine);
			  }	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return original.toString().equals(saved.toString());
	}
	
	@Test
	public void LoadingChess1() throws IllegalPieceCountException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-01.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		try {
			serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void LoadingChess2() throws IllegalPieceCountException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-02.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		try {
			serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void LoadingChess3() throws IllegalPieceCountException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-03.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		try {
			serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void LoadingStartUp() throws IllegalPieceCountException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-startup.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		try {
			serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void SavingChess1() throws IllegalPieceCountException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-01.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		ChessBoard board = null;
		try {
			board = serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {
			e.printStackTrace();
		}
		assertNotNull(board);	
		
		String temp = null;
		try {
			temp = createTempFile(); 
			serializator.save(board, temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(compareFiles(file.getFile(), temp));
	}
	
	@Test
	public void SavingChess2() throws IllegalPieceCountException{
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-02.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		ChessBoard board = null;
		try {
			board = serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {
			e.printStackTrace();
		}
		assertNotNull(board);	
		
		String temp = null;
		try {
			temp = createTempFile(); 
			serializator.save(board, temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(compareFiles(file.getFile(), temp));
	}
	
	@Test
	public void SavingChess3() throws IllegalPieceCountException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-03.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		ChessBoard board = null;
		try {
			board = serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {
			e.printStackTrace();
		}
		assertNotNull(board);	
		
		String temp = null;
		try {
			temp = createTempFile(); 
			serializator.save(board, temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(compareFiles(file.getFile(), temp));
	}
	
	@Test
	public void SavingChessStartUp() throws IllegalPieceCountException{
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-startup.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		ChessBoard board = null;
		try {
			board = serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {
			e.printStackTrace();
		}
		assertNotNull(board);	
		
		String temp = null;
		try {
			temp = createTempFile(); 
			serializator.save(board, temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(compareFiles(file.getFile(), temp));
		
	}
	
	@Test
	public void CheckingStartupBoardGeneration() throws IllegalPieceCountException, WrongPieceException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL file = classLoader.getResource("chess-startup.txt");
		
		BoardSerializatorServiceImpl serializator = new BoardSerializatorServiceImpl();
		ChessBoard board = null;
		try {
			board = serializator.load(file.getFile());
		} catch (WrongPieceException | IOException e) {
			e.printStackTrace();
		}
		assertNotNull(board);	
		
		ChessBoard generatedBoard = ChessBoard.createNewBoard(); 
		String temp = null;
		try {
			temp = createTempFile(); 
			serializator.save(generatedBoard, temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(compareFiles(file.getFile(), temp));		
	}
	
	
	@Test(expected = IllegalPieceCountException.class)
	public void checkMaxPawnsAllowed() throws IllegalPieceCountException, WrongPieceException {
		ChessBoard generatedBoard = ChessBoard.createNewBoard(); 
		generatedBoard.putPieceAtPosition(new Piece(PieceType.PAWN, Color.BLACK), new Position(5, 5));
	}

	@Test(expected = IllegalPieceCountException.class)
	public void checkMaxQueensAllowed() throws IllegalPieceCountException, WrongPieceException {
		ChessBoard generatedBoard = ChessBoard.createNewBoard(); 
		generatedBoard.putPieceAtPosition(new Piece(PieceType.QUEEN, Color.WHITE), new Position(5, 5));
	}
}
