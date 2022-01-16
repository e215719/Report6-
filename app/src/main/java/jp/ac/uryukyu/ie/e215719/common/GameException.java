package jp.ac.uryukyu.ie.e215719.common;

/**
 * 例外クラス。
 *  GameError error; //エラー名の列挙
 */
public class GameException extends Exception {

    private final GameError error;
    public enum GameError { //enumで列挙
        MOVE_PARSE_ERROR,
        NO_PIECE_TO_MOVE,
        CANNOT_MOVE_OPPONENTS_PIECE,
        MOVE_RULE_VIOLATION,
        CANNOT_MOVE_OBSTACLE
    }
    
    public GameException(GameError error) {
        super();
        this.error = error;
    }

    /**
    * 駒が存在するか判定するメソッド。
    * @param x x座標
    * @param y y座標
    */
    @Override
    public String getMessage() {
        switch (error) {
            case MOVE_PARSE_ERROR:
                return "存在しない座標";
            case NO_PIECE_TO_MOVE:
                return "そこに駒はありません";
            case CANNOT_MOVE_OPPONENTS_PIECE:
                return "自分の駒ではありません";
            case MOVE_RULE_VIOLATION:
                return "この駒はそこに移動できない";
            case CANNOT_MOVE_OBSTACLE:
                return "他の駒があります";
            default:
                throw new AssertionError(error.name());
        }
    }
}