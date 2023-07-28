class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] sum = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            sum[i] = s;
            map.put(s, i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int t = sum[i] - target;
            if (map.containsKey(t)) {
                int idx = map.get(t);
                if (idx >= 0) {
                    dp[i] = dp[idx] + 1;
                } else {
                    dp[i] = 1;
                }
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}