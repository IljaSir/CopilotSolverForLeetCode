class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] sum = new int[n];
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum[i] = nums[i] + (i > 0 ? sum[i - 1] : 0);
            dp[i] = (i > 0 ? dp[i - 1] : 0);
            if (map.containsKey(sum[i] - target)) {
                dp[i] = Math.max(dp[i], (map.get(sum[i] - target) >= 0 ? dp[map.get(sum[i] - target)] : 0) + 1);
            }
            ans = Math.max(ans, dp[i]);
            map.put(sum[i], i);
        }
        return ans;
    }
}