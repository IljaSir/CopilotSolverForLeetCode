class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        
        int n = aliceValues.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = aliceValues[i] + bobValues[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceScore += aliceValues[pairs[i][1]];
            } else {
                bobScore += bobValues[pairs[i][1]];
            }
        }
        return aliceScore == bobScore ? 0 : (aliceScore > bobScore ? 1 : -1);
    }
}