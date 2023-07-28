class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            sum += arr[i-1];
            if (map.containsKey(sum-target)) {
                int l = map.get(sum-target);
                dp[i] = i-l;
                if (l > 0 && dp[l] != -1) {
                    ans = Math.min(ans, dp[l] + dp[i]);
                }
            }
            map.put(sum, i);
            if (i > 1 && dp[i-1] != -1) {
                dp[i] = dp[i-1];
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}