package ru.maxlap.pet_prj;

public class Bishop extends LinearFigure{

    // Слон. наследуем от линейной фигуры, прописываем в linesCheck описание всех 4-х диагональных направлений
    public Bishop(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
        this.inboardChar = 'B';
        this.russianName = "слон";
        this.linesCheck=new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};

    }
}
