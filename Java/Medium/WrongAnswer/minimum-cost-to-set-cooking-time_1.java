class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                if (i * 60 + j == targetSeconds) {
                    int[] digits = new int[]{i / 10, i % 10, j / 10, j % 10};
                    int currentCost = 0;
                    for (int k = 0; k < 4; k++) {
                        int diff = Math.abs(startAt - digits[k]);
                        currentCost += Math.min(diff, 10 - diff);
                        startAt = digits[k];
                    }
                    cost = Math.min(cost, currentCost * pushCost);
                }
            }
        }
        return cost;
    }
}