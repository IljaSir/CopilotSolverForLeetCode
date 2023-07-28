class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            dp[i][0] = arr1[i] + arr2[i] + i;
            dp[i][1] = arr1[i] + arr2[i] - i;
            dp[i][2] = -arr1[i] + arr2[i] + i;
            dp[i][3] = -arr1[i] + arr2[i] - i;
        }
        int[] min = new int[4];
        int[] max = new int[4];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                min[j] = Math.min(min[j], dp[i][j]);
                max[j] = Math.max(max[j], dp[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = Math.max(res, max[i] - min[i]);
        }
        return res;
    }
}