class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while (right < n) {
            while (right < n && prefix[right+1] - prefix[left] < target) {
                right++;
            }
            if (right < n && prefix[right+1] - prefix[left] == target) {
                if (left > 0 && dp[left-1] != 0) {
                    ans = Math.min(ans, dp[left-1] + right - left + 1);
                }
                if (right < n-1 && dp[n-1] - dp[right] != 0) {
                    ans = Math.min(ans, dp[n-1] - dp[right] + right - left + 1);
                }
                min = Math.min(min, right - left + 1);
            }
            dp[right] = min;
            left++;
            right++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}