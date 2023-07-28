class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        
        int n = aliceValues.length;
        int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            points[i][0] = aliceValues[i] + bobValues[i];
            points[i][1] = aliceValues[i];
            points[i][2] = bobValues[i];
        }
        Arrays.sort(points, (a, b) -> b[0] - a[0]);
        int alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += points[i][1];
            } else {
                bob += points[i][2];
            }
        }
        return alice == bob ? 0 : alice > bob ? 1 : -1;
    }
}