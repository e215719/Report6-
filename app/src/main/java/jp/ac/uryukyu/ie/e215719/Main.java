package jp.ac.uryukyu.ie.e215719;
import java.util.Scanner;

import jp.ac.uryukyu.ie.e215719.common.GameException;

public class Main {
    public static final String PROMPT_FORMAT = "%sの番です。%dターン目>";
    public static final String WELCOME_MESSAGE = "ゲームを開始します。";
    public static final String HELP_MESSAGE //ヘルプメッセージ
            = "動きの入力方法: \n"
            + "たとえば、「a1,a2」と入力して、a1にある駒をa2に移動します。";
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean gameFinished = false;
        System.out.println(WELCOME_MESSAGE);
        System.out.println(HELP_MESSAGE);
        while (true) {
            System.out.print(board.getDisplayString()); //盤を出力
            gameFinished = board.end();
            if (gameFinished) {
                System.out.println("ゲームが終了しました");
                break;
            } else {
                System.out.format(PROMPT_FORMAT, board.isRedTurn() ? "赤" : "青", board.getMoveCount());
                line = scanner.nextLine(); //一行読み取り
                System.out.println(line);
                try {
                    board.move(line); //駒を動かす
                } catch (GameException ex) {
                    System.out.println("エラー: " + ex.getMessage());
                }
            }
        }
    }
}