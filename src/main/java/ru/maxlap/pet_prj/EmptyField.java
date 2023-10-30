package ru.maxlap.pet_prj;

public class EmptyField extends FieldData{

    // Пустое (но не открытое поле) обозначается * при любом режиме печати доски
    public EmptyField(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
    }

    public boolean isEmpty(){return true;}
    public boolean isFree(){ return true; }
    public void printInBoard(boolean showFigures){
       System.out.print('*');
    }
}
