package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Piece;
import net.kjk402.chess.pieces.Piece.*;
import net.kjk402.chess.pieces.Position;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>(Board.BOARD_SIZE);

    public Piece getPiece(int rankIndex) {
        return pieceList.get(rankIndex);
    }

    public static Rank createWhitePiecesRank(int rankIndex) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook(new Position(0, rankIndex)));
        rank.addPiece(Piece.createWhiteKnight(new Position(1, rankIndex)));
        rank.addPiece(Piece.createWhiteBishop(new Position(2, rankIndex)));
        rank.addPiece(Piece.createWhiteQueen(new Position(3, rankIndex)));
        rank.addPiece(Piece.createWhiteKing(new Position(4, rankIndex)));
        rank.addPiece(Piece.createWhiteBishop(new Position(5, rankIndex)));
        rank.addPiece(Piece.createWhiteKnight(new Position(6, rankIndex)));
        rank.addPiece(Piece.createWhiteRook(new Position(7, rankIndex)));
        return rank;
    }

    public static Rank createBlackPiecesRank(int rankIndex) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook(new Position(0, rankIndex)));
        rank.addPiece(Piece.createBlackKnight(new Position(1, rankIndex)));
        rank.addPiece(Piece.createBlackBishop(new Position(2, rankIndex)));
        rank.addPiece(Piece.createBlackQueen(new Position(3, rankIndex)));
        rank.addPiece(Piece.createBlackKing(new Position(4, rankIndex)));
        rank.addPiece(Piece.createBlackBishop(new Position(5, rankIndex)));
        rank.addPiece(Piece.createBlackKnight(new Position(6, rankIndex)));
        rank.addPiece(Piece.createBlackRook(new Position(7, rankIndex)));
        return rank;
    }

    public static Rank createWhitePawnsRank(int rankIndex) {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            rank.addPiece(Piece.createWhitePawn(new Position(i, rankIndex)));
        }
        return rank;
    }

    public static Rank createBlackPawnsRank(int rankIndex) {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            rank.addPiece(Piece.createBlackPawn(new Position(i, rankIndex)));
        }
        return rank;
    }

    public static Rank creatBlankLine(int rankIndex) {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            rank.addPiece(Piece.createBlank(new Position(i, rankIndex)));
        }
        return rank;
    }

    public int countPiece(Color color, Type type) {
        int count = 0;
        for (Piece piece : pieceList) {
            if (piece.getColor() == color && piece.getType() == type) {
                count++;
            }
        }
        return count;
    }

    public void move(int position, Piece piece) {
        pieceList.set(position, piece);
    }

    public double getPoint(Rank rank, Color color) {
        double sum = 0.0;
        for (Piece piece : rank.getPieceList()) {
            if (piece.getColor() == color) {
                sum += piece.getType().getDefaultPoint();
            }
        }
        return sum;
    }

    public String getRepresentationByRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieceList()) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    private void addPiece(Piece piece) {
        if (pieceList.size() < Board.BOARD_SIZE) {
            pieceList.add(piece);
        }
    }

    private List<Piece> getPieceList() {
        return pieceList;
    }

    private Rank() {

    }

}
