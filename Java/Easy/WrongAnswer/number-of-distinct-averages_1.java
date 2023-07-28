class Solution {
    public int distinctAverages(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = sum[n] - sum[i];
        }
        for (int i = 1; i < n; i++) {
            int[] next = new int[n];
            for (int j = i; j < n; j++) {
                int lo = j + 1, hi = n;
                while (lo < hi) {
                    int mi = (lo + hi) / 2;
                    if (nums[j] * (mi - j) + dp[mi] >= nums[mi] * (mi - j) + dp[j]) {
                        lo = mi + 1;
                    } else {
                        hi = mi;
                    }
                }
                next[j] = Math.max(dp[j], dp[lo - 1]);
                if (lo < n) {
                    next[j] = Math.max(next[j], (sum[lo] - sum[j]) * (lo - j));
                }
            }
            dp = next;
        }
        return n - dp[n - 1];
    }
}