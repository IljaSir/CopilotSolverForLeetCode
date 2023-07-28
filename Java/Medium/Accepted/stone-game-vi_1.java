class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        
        int n = aliceValues.length;
        int[][] sum = new int[n][3];
        for (int i = 0; i < n; i++) {
            sum[i][0] = aliceValues[i] + bobValues[i];
            sum[i][1] = aliceValues[i];
            sum[i][2] = bobValues[i];
        }
        Arrays.sort(sum, (a, b) -> b[0] - a[0]);
        int alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += sum[i][1];
            } else {
                bob += sum[i][2];
            }
        }
        return Integer.compare(alice, bob);
    }
}