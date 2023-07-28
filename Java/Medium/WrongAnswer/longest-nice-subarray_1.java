class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((prefix[j] ^ prefix[i]) == 0) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }
}