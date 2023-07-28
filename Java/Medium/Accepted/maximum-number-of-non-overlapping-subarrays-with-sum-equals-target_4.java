class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        int n = nums.length;
        int[] dp = new int[n+1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i-1];
            dp[i] = dp[i-1];
            if (map.containsKey(sum-target)) {
                dp[i] = Math.max(dp[i], dp[map.get(sum - target)] + 1);
            }
            map.put(sum, i);
        }
        return dp[n];
    }
}