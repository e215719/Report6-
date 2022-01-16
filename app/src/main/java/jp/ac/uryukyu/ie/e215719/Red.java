package jp.ac.uryukyu.ie.e215719;

public class Red extends Piece{ //赤の駒

    public Red(int x, int y, boolean color) {
        super(x, y, color);
    }

    @Override
    public char toChar() { //盤に表示させる文字
        return 'R';
    }

}