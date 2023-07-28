class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, -1);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            dp[i] = ans;
            if (map.containsKey(sum - target)) {
                int j = map.get(sum - target);
                dp[i] = Math.max(dp[i], j >= 0 ? dp[j] + 1 : 1);
            }
            ans = Math.max(ans, dp[i]);
            map.put(sum, i);
        }
        return ans;
    }
}