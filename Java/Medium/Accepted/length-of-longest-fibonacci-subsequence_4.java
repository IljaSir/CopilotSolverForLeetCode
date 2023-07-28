class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = arr[i] + arr[j];
                if (map.containsKey(target)) {
                    int k = map.get(target);
                    dp[j][k] = dp[i][j] + 1;
                    max = Math.max(max, dp[j][k]);
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}