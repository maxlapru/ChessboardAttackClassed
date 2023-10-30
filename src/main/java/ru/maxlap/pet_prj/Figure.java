package ru.maxlap.pet_prj;

public abstract class Figure extends FieldData {
    // Класс фигуры (любая фигура (не пустое и открытое поле) наследуються от него
    public Figure(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
    }

    public boolean isFree(){
        return false;
    }

    public boolean isOpen(){
        return false;
    }

    public boolean isEmpty(){
        return false;
    }



}
