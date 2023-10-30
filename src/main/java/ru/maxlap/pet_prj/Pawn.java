package ru.maxlap.pet_prj;

public class Pawn extends PointFigure{
    // Пешка
    public Pawn(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
        this.inboardChar = 'P';
        this.russianName = "пешка";
        this.poinnts=new int[][]{{-1,-1},{-1,1}}; // Описываем точки, которые бъет пешка
    }
}
