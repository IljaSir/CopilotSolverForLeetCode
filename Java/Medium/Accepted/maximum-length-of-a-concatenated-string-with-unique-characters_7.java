class Solution {
    public int maxLength(List<String> arr) {
        
        int[] dp = new int[]{0};
        dfs(arr, 0, 0, dp);
        return dp[0];
    }
    
    private void dfs(List<String> arr, int i, int mask, int[] dp) {
        if (i == arr.size()) {
            dp[0] = Math.max(dp[0], Integer.bitCount(mask));
            return;
        }
        
        String s = arr.get(i);
        int m = 0;
        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((m & bit) != 0) {
                m = 0;
                break;
            }
            m |= bit;
        }
        if (m != 0 && (mask & m) == 0) {
            dfs(arr, i + 1, mask | m, dp);
        }
        dfs(arr, i + 1, mask, dp);
    }
}