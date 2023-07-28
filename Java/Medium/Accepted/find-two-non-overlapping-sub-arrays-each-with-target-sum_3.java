class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
            if (map.containsKey(sum - target)) {
                int j = map.get(sum - target);
                if (j >= 0 && dp[j] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, dp[j] + i - j);
                }
                best = Math.min(best, i - j);
            }
            dp[i] = best;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}