class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                int j = map.get(sum - target);
                dp[i] = i - j + (j > 0 ? dp[j - 1] : 0);
                if (j > 0 && dp[j - 1] > 0) {
                    min = Math.min(min, dp[i] + dp[j - 1]);
                }
            }
            if (i > 0 && dp[i - 1] > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            map.put(sum, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}