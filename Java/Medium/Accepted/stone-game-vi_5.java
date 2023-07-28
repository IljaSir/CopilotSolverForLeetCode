class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        
        int n = aliceValues.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = aliceValues[i] + bobValues[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += aliceValues[arr[i][1]];
            } else {
                bob += bobValues[arr[i][1]];
            }
        }
        return alice > bob ? 1 : alice == bob ? 0 : -1;
    }
}