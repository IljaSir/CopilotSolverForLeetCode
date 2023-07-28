class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum[j] - sum[i] == 0) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }
}