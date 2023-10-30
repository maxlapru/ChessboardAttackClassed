package ru.maxlap.pet_prj;

import java.text.DecimalFormat;
import java.util.Random;

// Сама доска, размер задаеться в конструкторе при инициализации
public class ChessBoard {
    private FieldData[][] board;

    private static final char[] FIGURES = {'K', 'Q', 'B', 'B', 'N', 'N', 'R', 'R', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'};
    private static final Random RANDOM = new Random();
    private int sizeX;
    private int sizeY;
    private int openFieldAttemps;
    private int figuresCount;

    public ChessBoard(int sizeX,int sizeY,int numberOfKids,int openFieldAttemps){
        // Инициализация
        this.board = new FieldData[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.openFieldAttemps = openFieldAttemps;
        // Все поля изначально пустые
        for (int i=0;i<sizeX;i++){
            for (int j=0;j<sizeY;j++){
                this.board[i][j]=new EmptyField(i,j,this);
            }
        }
        // Расстановка фигур
        for (int k=1;k<=numberOfKids;k++){
            for (int f=0;f<FIGURES.length;f++){
                int x,y;
                FieldData fg;
                do{
                    x=RANDOM.nextInt(sizeX-1)+1;
                    y=RANDOM.nextInt(sizeY);
                } while (!board[x][y].isEmpty());
                switch (FIGURES[f]){
                    case ('R'):
                        fg = new Rook(x,y,this);
                        break;
                    case ('B'):
                        fg = new Bishop(x,y,this);
                        break;
                    case ('Q'):
                        fg = new Queen(x,y,this);
                        break;
                    case ('N'):
                        fg = new Knight(x,y,this);
                        break;
                    case ('P'):
                        fg = new Pawn(x,y,this);
                        break;
                    case ('K'):
                        fg = new King(x,y,this);
                        break;
                    default:
                        fg = new OpenedField(x,y,this);
                        break;
                }
                board[x][y] = fg;
                this.figuresCount++;
            }
        }
        // Расстановка фигур окончена
    }

    private void printHeaderFooter(){
        // вывод в консоль заголовка и футера (там список вертикалей по буквам)
        System.out.print("   ");
        for(int j=0; j<this.sizeY; j++){
            System.out.print((char) (65+j));
            System.out.print(" ");
        }
        System.out.println();
    }

    public void printBoard(boolean showFigures){
        // Печатаем в консоль саму доску
        DecimalFormat dF = new DecimalFormat("00");
        printHeaderFooter();
        for(int i =this.sizeX-1; i>=0; i--){
            // Слева номер горизонтали
            System.out.printf(dF.format(i+1));
            System.out.print("|");
            // Выводим все поля горизонтали
            for(int j=0; j<sizeY; j++){
                board[i][j].printInBoard(showFigures);
                System.out.print("|");
            }
            System.out.println();
        }
        printHeaderFooter();
    }

    public boolean isFieldValid(int x,int y){
        // true - координаты не выскакивают за края доски, false в противном случае
        {
            return (x>=0 && y>=0 && x<this.sizeX && y<this.sizeY);
        }
    }

    // проверка
    public boolean isFieldFree(int x,int y){
        return this.board[x][y].isFree();
    }

    public boolean openFigureField(int x,int y) {
        if (this.board[x][y].isOpen()) { return true; }
        boolean thisFieldIsEmpty=this.board[x][y].isEmpty();
        if (thisFieldIsEmpty) {
            System.out.printf("На данном поле нет фигуры, осталось попыток открытия: %d %n",--this.openFieldAttemps);
            if (this.openFieldAttemps<=0) {
                System.out.println("Все попытки открытия закончились, вы проиграли !!!");
                return false;
            }
        } else {
            System.out.println("На данном поле была фигура "+ this.board[x][y].getRussianName() +", сейчас она убрана");
            this.board[x][y]=new OpenedField(x,y,this);
            this.figuresCount--;
            if (this.figuresCount>0){
                System.out.printf("На доске осталось %d фигур.%n",this.figuresCount);
            } else {
                System.out.printf("Фигур больше не осталось, вы выиграли!%n");
                return false;
            }
        }
        return true;
    }

    public boolean openField(int x,int y){
        if (this.board[x][y].isFree()) {
            String attachedFigures = "";
            for (int i=0;i<this.sizeX;i++){
                for (int j=0;j<this.sizeY;j++){
                    if (this.board[i][j].isAttached(x,y)) {
                        attachedFigures=attachedFigures+","+this.board[i][j].getRussianName();
                    }
                }
            }
            if (attachedFigures!="") {
                attachedFigures=attachedFigures.substring(1);
                System.out.println("Заданное поле атакуют: " + attachedFigures);
            }
            if (this.board[x][y].isEmpty()) {
                this.board[x][y]=new OpenedField(x,y,this);
            }
            return true;
        } else {
            System.out.println("Вы проиграли!");
            return false;
        }
    }

}
