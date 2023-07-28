class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
            if (map.containsKey(sum - target)) {
                int j = map.get(sum - target);
                if (j >= 0 && dp[j] != Integer.MAX_VALUE) {
                    res = Math.min(res, dp[j] + i - j);
                }
                minLen = Math.min(minLen, i - j);
            }
            dp[i] = minLen;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}