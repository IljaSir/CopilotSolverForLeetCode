class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
            if(map.containsKey(sum - target)) {
                int j = map.get(sum - target);
                dp[i] = i - j + (j > 0 ? dp[j - 1] : 0);
            }
            if(i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            if(map.containsKey(sum + target)) {
                int j = map.get(sum + target);
                if(j < i) {
                    res = Math.min(res, dp[j] + i - j);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}