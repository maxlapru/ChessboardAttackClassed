package ru.maxlap.pet_prj;

public class King extends PointFigure{
    // король
    public King(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
        this.inboardChar = 'K';
        this.russianName = "король";
        this.poinnts = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}}; // матрица точек, которые бъет король
    }
}
