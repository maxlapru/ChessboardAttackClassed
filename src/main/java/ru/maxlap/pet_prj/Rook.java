package ru.maxlap.pet_prj;

public class Rook extends LinearFigure{
    // Ладья
    public Rook(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
        this.inboardChar = 'R';
        this.russianName = "ладья";
        this.linesCheck = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        // описание вертикальных направлений.
    }
}
