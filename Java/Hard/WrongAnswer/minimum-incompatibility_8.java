class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            int[] next = new int[1 << n];
            Arrays.fill(next, Integer.MAX_VALUE);
            int start = (1 << n) / k * (i - 1);
            int end = (1 << n) / k * i;
            for (int j = start; j < end; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;
                int[] used = new int[17];
                for (int l = 0; l < n; l++) {
                    if ((j & (1 << l)) == 0) continue;
                    used[nums[l]]++;
                }
                for (int l = 0; l < n; l++) {
                    if ((j & (1 << l)) != 0) continue;
                    if (used[nums[l]] > 0) continue;
                    used[nums[l]]++;
                    next[j | (1 << l)] = Math.min(next[j | (1 << l)], dp[j] + getDiff(j, nums, l));
                }
            }
            dp = next;
        }
        return dp[(1 << n) - 1];
    }
    private int getDiff(int j, int[] nums, int l) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if ((j & (1 << i)) == 0) continue;
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min;
    }
}