package jp.ac.uryukyu.ie.e215719;

/**
 * 赤駒クラス。
 */
public class Red extends Piece{

    /**
     * コンストラクタ。x座標、y座標、色を指定する。
     * @param x x座標
     * @param y y座標
     * @param color 色
     */
    public Red(int x, int y, boolean color) {
        super(x, y, color);
    }

    /**
     * 盤に駒の色を表示する文字返すメソッド。
     */
    @Override
    public char toChar() {
        return 'R';
    }

}