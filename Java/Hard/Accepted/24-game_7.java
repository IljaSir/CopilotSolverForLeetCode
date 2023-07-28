class Solution {
    public boolean judgePoint24(int[] cards) {
        
        return judgePoint24(new double[]{cards[0], cards[1], cards[2], cards[3]});
    }
    public boolean judgePoint24(double[] cards) {
        if (cards.length == 1) {
            return Math.abs(cards[0] - 24) < 1e-6;
        }
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                if (i != j) {
                    double[] next = new double[cards.length - 1];
                    for (int k = 0, l = 0; k < cards.length; k++) {
                        if (k != i && k != j) {
                            next[l++] = cards[k];
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;
                        }
                        if (k == 0) {
                            next[cards.length - 2] = cards[i] + cards[j];
                        } else if (k == 1) {
                            next[cards.length - 2] = cards[i] * cards[j];
                        } else if (k == 2) {
                            next[cards.length - 2] = cards[i] - cards[j];
                        } else if (k == 3) {
                            if (cards[j] != 0) {
                                next[cards.length - 2] = cards[i] / cards[j];
                            } else {
                                continue;
                            }
                        }
                        if (judgePoint24(next)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}