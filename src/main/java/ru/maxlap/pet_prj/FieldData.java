package ru.maxlap.pet_prj;

public abstract class FieldData {
    // Самый системообразующий класс - данные поля. От него наследуются все фигуры, а также служебные классы "Открытое поле"
    // и "пустое поле"
    protected int coordX;  // Номер горизонтали

    protected int coordY;  // Номер вертикали

    protected ChessBoard board;  // Объект доски
    protected char inboardChar;  // Одиночный символ, выводящийся при печати доски для этой фигуры
    protected String russianName; // Русскоязычное имя фигуры, для служебных полей "Пустое" и "Открытое" не используется и равно пустой строке
    public FieldData(int coordX,int coordY,ChessBoard board){
        this.board=board;
        this.coordX=coordX;
        this.coordY=coordY;
    }
    public boolean isAttached(int x,int y){
        return false;
    }  // Атакует ли фигура, стоящая на этом поле другое поле с координатами X и Y

    public boolean isFree(){
        return false;
    }  // isEmpty || isOpen  - для удобства

    public boolean isEmpty(){return false; }   // true - поле пустое не занято фигурой, false в противном слкучае

    public boolean isOpen(){return false;}    // true - это поле является открытым и пустым false в противном случае
    public void printInBoard(boolean showFigures){
        // Процедура печати поля доски
        // showFigures - показывать фигуры (применяется при отладке и финальной печати в случае проигрыша)
        if (showFigures){
            // печатаем символ фигуры
            System.out.print(this.inboardChar);
        } else {
            // печатаем маскирующую звездочку
            System.out.print('*');
        }
    }

    public String getRussianName(){
        // Getter
        return this.russianName;
    }

}
