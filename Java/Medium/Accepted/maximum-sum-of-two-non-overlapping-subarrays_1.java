class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = firstLen; i <= n; i++) {
            int first = sum[i] - sum[i - firstLen];
            for (int j = 0; j + secondLen <= i - firstLen; j++) {
                int second = sum[j + secondLen] - sum[j];
                ans = Math.max(ans, first + second);
            }
            for (int j = i + secondLen; j <= n; j++) {
                int second = sum[j] - sum[j - secondLen];
                ans = Math.max(ans, first + second);
            }
        }
        return ans;
    }
}