class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = i;
        }
        Arrays.sort(sorted, (a, b) -> {
            return arr[a] - arr[b];
        });
        for (int i = 0; i < n; i++) {
            int index = sorted[i];
            for (int j = index + 1; j <= Math.min(n - 1, index + d); j++) {
                if (arr[j] >= arr[index]) break;
                dp[index] = Math.max(dp[index], dp[j] + 1);
            }
            for (int j = index - 1; j >= Math.max(0, index - d); j--) {
                if (arr[j] >= arr[index]) break;
                dp[index] = Math.max(dp[index], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}