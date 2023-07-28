class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int y = x - difference;
            int count = dp.getOrDefault(y, 0) + 1;
            dp.put(x, count);
            ans = Math.max(ans, count);
        }
        return ans;
    }
}