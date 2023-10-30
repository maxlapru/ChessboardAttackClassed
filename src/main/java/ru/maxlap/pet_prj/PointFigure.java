package ru.maxlap.pet_prj;

public abstract class PointFigure extends Figure{
    // "Точечная" фигура. Ту, ходы которой можно описать относительными смещениями от текущей координаты
    protected int[][] poinnts;
    public PointFigure(int coordX,int coordY,ChessBoard board){
        super(coordX,coordY,board);
    }

    public boolean isAttached(int x,int y){
        for (int i=0;i<this.poinnts.length;i++){
            int dx = this.coordX + this.poinnts[i][0];
            int dy = this.coordY + this.poinnts[i][1];
            if (this.board.isFieldValid(dx,dy)) {
                if (dx==x && dy == y) {return true;}
            }
        }
        return false;
    }

}
