package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Piece;
import net.kjk402.chess.pieces.Piece.*;
import net.kjk402.chess.pieces.Position;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>(Board.BOARD_SIZE);

    public void addPiece(Piece piece) {
        pieceList.add(piece);
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public Piece getPiece(int rankIndex) {
        return pieceList.get(rankIndex);
    }

    public static Rank setWhitePieces(int index) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook(new Position(0, index)));
        rank.addPiece(Piece.createWhiteKnight(new Position(1, index)));
        rank.addPiece(Piece.createWhiteBishop(new Position(2, index)));
        rank.addPiece(Piece.createWhiteQueen(new Position(3, index)));
        rank.addPiece(Piece.createWhiteKing(new Position(4, index)));
        rank.addPiece(Piece.createWhiteBishop(new Position(5, index)));
        rank.addPiece(Piece.createWhiteKnight(new Position(6, index)));
        rank.addPiece(Piece.createWhiteRook(new Position(7, index)));
        return rank;
    }

    public static Rank setBlackPieces(int index) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook(new Position(0, index)));
        rank.addPiece(Piece.createBlackKnight(new Position(1, index)));
        rank.addPiece(Piece.createBlackBishop(new Position(2, index)));
        rank.addPiece(Piece.createBlackQueen(new Position(3, index)));
        rank.addPiece(Piece.createBlackKing(new Position(4, index)));
        rank.addPiece(Piece.createBlackBishop(new Position(5, index)));
        rank.addPiece(Piece.createBlackKnight(new Position(6, index)));
        rank.addPiece(Piece.createBlackRook(new Position(7, index)));
        return rank;
    }

    public static Rank setWhitePawns(int index) {
        Rank rank = new Rank();
        for(int i =0; i< Board.BOARD_SIZE; i++) {
            rank.addPiece(Piece.createWhitePawn(new Position(i, index)));
        }
        return rank;
    }

    public static Rank setBlackPawns(int index) {
        Rank rank = new Rank();
        for(int i =0; i< Board.BOARD_SIZE; i++) {
            rank.addPiece(Piece.createBlackPawn(new Position(i, index)));
        }
        return rank;
    }

    public static Rank setBlackLine(int index) {
        Rank rank = new Rank();
        for(int i =0; i< Board.BOARD_SIZE; i++) {
            rank.addPiece(Piece.createBlank(new Position(i, index)));
        }
        return rank;
    }

    public void move(int position, Piece piece) {
        pieceList.set(position, piece);
    }

}
