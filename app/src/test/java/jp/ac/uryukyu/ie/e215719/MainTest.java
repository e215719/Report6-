package jp.ac.uryukyu.ie.e215719;

import jp.ac.uryukyu.ie.e215719.common.GameException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    /**
     * 駒が正しく移動していることを検証.
     * 検証手順
     *  (1) 盤を準備。盤の駒の状態は初期位置とする。
     *  (2) a1の駒がa2に移動していることを期待。
     *  (3) 移動後はa1に駒がなく、a2に駒があるはず。
     * 　　つまりa1にはnullがa2には赤駒のオブジェクトがあることを検証する。
     */
    @Test   
    void moveTest() {
        Board testBoard = new Board();
        System.out.println(testBoard.getDisplayString());
        assertEquals(testBoard.gameboard[0][0], "R");
        assertEquals(testBoard.gameboard[0][1], null);
        String moveText = "a1,a2";
        try {
            testBoard.move(moveText); //駒を動かす
        } catch (GameException ex) {
            System.out.println("エラー: " + ex.getMessage());
        }
        System.out.println(testBoard.getDisplayString());
        assertEquals(testBoard.gameboard[0][0], null);
        assertEquals(testBoard.gameboard[0][1], "R");
    }
}