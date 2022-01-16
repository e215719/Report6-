package jp.ac.uryukyu.ie.e215719;

/**
 * 駒クラス。
 *  int x; //x座標
 *  int y; //y座標
 *  boolean color; //駒の色。true=赤。
 */
public abstract class Piece {

    private int x;
    private int y;
    private boolean color;

    /**
     * コンストラクタ。x座標、y座標、色を指定する。
     * @param x x座標
     * @param y y座標
     * @param color 色
     */
    public Piece (int x, int y, boolean color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
    * xのgetterメソッド。
    * xを取得する。
    * @param x 取得対象
    */
    public int getX() {
        return this.x;
    }
    /**
    * yのsetterメソッド。
    * yを取得する。
    * @param y 取得対象
    */
    public int getY() {
        return this.y;
    }
    /**
    * xのsetterメソッド。
    * xを設定する。
    * @param x 取得対象
    */
    public void setX(int x) {
        this.x = x;
    }
    /**
    * yのgetterメソッド。
    * yを設定する。
    * @param y 取得対象
    */
    public void setY(int y) {
        this.y = y;
    }

    /**
    * 駒の色を判定するメソッド。
    * 赤ならtrue、青ならfalse。
    * @param color 取得対象
    */
    public boolean isRed() {
        return color;
    }


    /**
    * 駒の動ける範囲を判定するメソッド。
    * 今いる座標からルールに従って動ける座標を判定.
    * @param sourceX 今いるx座標
    * @param sourceY 今いるy座標
    * @param targetX 目的のx座標
    * @param targetY 目的のy座標
    */
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