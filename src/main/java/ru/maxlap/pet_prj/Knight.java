package ru.maxlap.pet_prj;

public class Knight extends PointFigure{
    // конь
    public Knight(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
        this.inboardChar = 'N';
        this.russianName = "конь";
        this.poinnts = new int[][]{{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}}; // матрица точек, которые бъет конь
    }
}
