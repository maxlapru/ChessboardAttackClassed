package ru.maxlap.pet_prj;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final boolean DEBUG_MODE=false;
    public static void main(String[] args) {
        String buffer;
        int coordX,coordY;
        boolean figureFound,result;
        ChessBoard board = new ChessBoard(8, 8, 1, 7);
        board.printBoard(DEBUG_MODE);
        while (true) {
            do {
                System.out.println("Введиде на экран координаты в шахматной нотации");
                buffer = SCANNER.nextLine().toUpperCase();
                figureFound = (buffer.charAt(0) == '!');
                if (figureFound) {
                    buffer = buffer.substring(1);
                }
                coordY = (int) buffer.charAt(0);
                coordY -= 65;
                coordX = Integer.parseInt(buffer.substring(1)) - 1;
            } while (!board.isFieldValid(coordX,coordY));
            if (figureFound) {
                result = board.openFigureField(coordX,coordY);
            } else {
                result = board.openField(coordX,coordY);
            }
            if (!result) {break;}
            board.printBoard(DEBUG_MODE);
        }
        board.printBoard(true);
    }
}