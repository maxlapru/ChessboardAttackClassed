package ru.maxlap.pet_prj;

public class OpenedField extends FieldData{

    // Служебный класс "открытое поле"
    public OpenedField(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
    }

    public boolean isOpen(){return true;}
    public boolean isFree(){ return true;}
    public void printInBoard(boolean showFigures){
        System.out.print(' ');
    }
}
