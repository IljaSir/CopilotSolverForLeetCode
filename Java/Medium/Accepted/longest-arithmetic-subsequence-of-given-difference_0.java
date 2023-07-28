class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i] - difference)) {
                dp[i] = dp[map.get(arr[i] - difference)] + 1;
            }
            map.put(arr[i], i);
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}