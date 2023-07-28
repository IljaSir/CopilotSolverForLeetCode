class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i] = i > 0 ? dp[i - 1] : 0;
            if (map.containsKey(sum - target)) {
                int pre = map.get(sum - target);
                dp[i] = Math.max(dp[i], pre >= 0 ? dp[pre] + 1 : 1);
            }
            map.put(sum, i);
        }
        return dp[n - 1];
    }
}