class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        
        int[][] sum = new int[aliceValues.length][3];
        for (int i = 0; i < aliceValues.length; i++) {
            sum[i][0] = aliceValues[i] + bobValues[i];
            sum[i][1] = aliceValues[i];
            sum[i][2] = bobValues[i];
        }
        Arrays.sort(sum, (a, b) -> b[0] - a[0]);
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < aliceValues.length; i++) {
            if (i % 2 == 0) {
                alice += sum[i][1];
            } else {
                bob += sum[i][2];
            }
        }
        if (alice > bob) {
            return 1;
        } else if (alice < bob) {
            return -1;
        } else {
            return 0;
        }
    }
}