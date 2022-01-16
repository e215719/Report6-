package jp.ac.uryukyu.ie.e215719;

import jp.ac.uryukyu.ie.e215719.common.GameException;

import java.util.Scanner;

/**
 * イギリス国旗の三目並べ(石並べ)。
 */
public class Main {
    public static final String PROMPT_FORMAT = "%sの番です。%dターン目>";
    public static final String WELCOME_MESSAGE = "ゲームを開始します。";
    public static final String HELP_MESSAGE //ヘルプメッセージ
            = "動きの入力方法: \n"
            + "たとえば、「a1,a2」と入力し、a1にある駒をa2に移動します。\n"
            + "「q」と入力し、途中で終了できます。";
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean gameFinished = false;
        System.out.println(WELCOME_MESSAGE);
        System.out.println(HELP_MESSAGE);
        while (true) {
            System.out.print(board.getDisplayString()); //盤を出力
            gameFinished = board.end(); //終了判定
            if (gameFinished) {
                System.out.println("ゲームが終了しました");
                break;
            } else {
                System.out.format(PROMPT_FORMAT, board.isRedTurn() ? "赤" : "青", board.getMoveCount());
                line = scanner.nextLine(); //一行読み取り
                if (line.equals("q")) { break; } //強制終了
                System.out.println(line);
                try {
                    board.move(line); //駒を動かす
                } catch (GameException ex) { //例外処理
                    System.out.println("エラー: " + ex.getMessage());
                }
            }
        }
    }
}