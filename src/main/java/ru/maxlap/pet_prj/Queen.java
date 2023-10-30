package ru.maxlap.pet_prj;

public class Queen extends LinearFigure{
    public Queen(int coordX,int coordY,ChessBoard board){
        // Ферзь
        super(coordX,coordY,board);
        this.inboardChar = 'Q';
        this.russianName = "ферзь";
        this.linesCheck = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        // Тута все горизонтали \ вертикали \ диагонали
    }
}
