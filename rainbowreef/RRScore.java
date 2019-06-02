package rainbowreef;

import java.util.ArrayList;

class RRScore {
    private boolean[] state;
    private int thisStage;
    private int aliveEnemys;
    private int score;
    private int live;
    int totalScore;
    private ArrayList<RRObject> objects;
    public int getLive() {
        return live;
    }
    RRScore(ArrayList<RRObject> objects, int i) {
        state = new boolean[]{false, false, false};
        thisStage = 0;
        aliveEnemys = 0;
        score = 0;
        this.objects = objects;
        live = 3;
        totalScore = i;
    }

    boolean isEndStage() {
        return state[0];
    }
    int getNextStage() {
        thisStage++;
        return thisStage;
    }
    boolean isWin() {
        return state[1];
    }
    int getWinStage() {
        return RRStage.getGameStageCount();
    }
    int getLooseStage() {
        return RRStage.getGameStageCount() + 1;
    }
    boolean isLoose() {
        return state[2];
    }
    int getCount() {
        return score;
    }

    void addEnemy() {
        aliveEnemys++;
    }
    void removeEnemy(RREnemy enemy) {
        score += enemy.getScore();
        objects.remove(enemy);
        aliveEnemys--;
        if (aliveEnemys == 0) {
            state[0] = true;
        }
    }

    void removeObj(RRBlock rrBlock) {
        score += rrBlock.getScore();
        objects.remove(rrBlock);
    }
    int getScore() {
        return score;
    }
    public void dieStar() {
        live--;
        if (live == 0) {
            state[2] = true;
        }
    }
}
