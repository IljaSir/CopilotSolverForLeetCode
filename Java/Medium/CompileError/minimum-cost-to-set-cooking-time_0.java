class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int l = 0; l <= 9; l++) {
                        int total = i * 600 + j * 60 + k * 10 + l;
                        if (total == targetSeconds) {
                            min = Math.min(min, cost(startAt, moveCost, pushCost, i, j, k, l));
                        }
                    }
                }
            }
        }
        return min;
    }
}