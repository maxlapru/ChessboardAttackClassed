package ru.maxlap.pet_prj;

public abstract class LinearFigure extends Figure{
    // Базовый класс для лин7ейных фигур, тут прописываеся алгоритм проверки "боя" по линиям
    protected int[][] linesCheck;

    public LinearFigure(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
    }

    @Override
    public final boolean isAttached(int x,int y){
        // Проходимся по описаниям линий и для каждой проверяем бъет ли наша фигура точку X|Y
        for (int i = 0;i<this.linesCheck.length;i++){
            int[] lineCheck = this.linesCheck[i];
            if (lineCheck(x,y,lineCheck[0],lineCheck[1])){
                return true;
            }
        }
        return false;
    };

    private boolean lineCheck(int x,int y,int kx,int ky){
        // "Прострел" линии
        int k = 1;
        int dx;
        int dy;
        while (true){
            // в цикле идем от начальной точки по описанию линии
            dx = this.coordX+k*kx;
            dy = this.coordY+k*ky;
            if (!this.board.isFieldValid(dx,dy)) {return false;} // Вылетели за край доски
            if (this.board.isFieldFree(dx,dy)){
                    // Путь Свободен
                    if (dx==x && dy == y) { return true; } // Добрались до точки
                    k++;
                } else {
                    // Путь преграждает другая фигура или пешка
                    return false;
                }
            }
    }
}
