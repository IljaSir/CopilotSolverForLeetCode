class Solution {
    public int longestSubarray(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] & nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (prefix[m] == prefix[i]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            ans = Math.max(ans, l - i);
        }
        return ans;
    }
}