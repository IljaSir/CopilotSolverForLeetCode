class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = arr[j] - arr[i];
                if (k >= arr[i]) {
                    break;
                }
                if (map.containsKey(k)) {
                    dp[i][j] = dp[map.get(k)][i] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}