package jp.ac.uryukyu.ie.e215719;

public abstract class Piece {

    private int x; //x座標
    private int y; //y座標
    private boolean color; //色

    public Piece (int x, int y, boolean color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean isRed() {
        return color;
    }

    public boolean isValid(int sourceX, int sourceY, int targetX, int targetY) { //駒の動ける範囲を判定する
        if (sourceX==0 && sourceY==0) {
            if (targetX==2 || targetY==2) { return false; }
        }  if (sourceX==0 && sourceY==2) {
            if (targetX==2 || targetY==0) { return false; }
        } if (sourceX==2 && sourceY==0) {
            if (targetX==0 || targetY==2) { return false; }
        } if (sourceX==2 && sourceY==2) {
            if (targetX==0 || targetY==0) { return false; }
        }
        else if (sourceX==0 && sourceY==1) {
            if (targetX==2) { return false; }
            if (targetX==1) {
                if (targetY==0 || targetY==2) { return false; }
            }
        }  if (sourceX==1 && sourceY==0) {
            if (targetY==2) { return false; }
            if (targetY==1) {
                if (targetX==0 || targetX==2) { return false; }
            }
        } if (sourceX==1 && sourceY==2) {
            if (targetY==0) { return false; }
            if (targetY==1) {
                if (targetX==0 || targetX==2) { return false; }
            }
        } if (sourceX==2 && sourceY==1) {
            if (targetX==0) { return false; }
            if (targetX==1) {
                if (targetY==0 || targetY==2) { return false; }
            }
        }
        return true;
    }

    public abstract char toChar(); //駒の種類で変える

}