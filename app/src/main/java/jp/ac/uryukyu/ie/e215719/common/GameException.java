package jp.ac.uryukyu.ie.e215719.common;
public class GameException extends Exception {

    private final GameError error;
    public enum GameError { //enumで列挙
        MOVE_PARSE_ERROR,
        NO_PIECE_TO_MOVE,
        CANNOT_MOVE_OPPONENTS_PIECE,
        CANNOT_MOVE_OBSTACLE,
        MOVE_RULE_VIOLATION
    }
    
    public GameException(GameError error) {
        super();
        this.error = error;
    }

    @Override
    public String getMessage() {
        switch (error) {
            case MOVE_PARSE_ERROR:
                return "存在しない座標";
            case NO_PIECE_TO_MOVE:
                return "そこに駒はありません";
            case CANNOT_MOVE_OPPONENTS_PIECE:
                return "自分の駒ではありません";
            case CANNOT_MOVE_OBSTACLE:
                return "他の駒があります";
            case MOVE_RULE_VIOLATION:
                return "この駒はそこに移動できない";
            default:
                throw new AssertionError(error.name());
        }
    }
}