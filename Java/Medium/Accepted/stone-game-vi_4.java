class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        
        int n = aliceValues.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = aliceValues[i];
            arr[i][1] = bobValues[i];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> -(a[0] + a[1] - b[0] - b[1]));
        int alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += arr[i][0];
            } else {
                bob += arr[i][1];
            }
        }
        return alice == bob ? 0 : alice > bob ? 1 : -1;
    }
}