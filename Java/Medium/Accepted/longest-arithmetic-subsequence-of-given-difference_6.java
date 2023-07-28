class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i] - difference)) {
                dp[i] = dp[map.get(arr[i] - difference)] + 1;
            } else {
                dp[i] = 1;
            }
            map.put(arr[i], i);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}