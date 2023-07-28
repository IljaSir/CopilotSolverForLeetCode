class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valToIndex.put(arr[i], i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];
                int c = a + b;
                if (valToIndex.containsKey(c)) {
                    int k = valToIndex.get(c);
                    dp[j][k] = dp[i][j] + 1;
                    ans = Math.max(ans, dp[j][k]);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }
}