class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int[] ans = new int[nums.length];
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] ^ nums[i-1];
        }
        int mask = (1 << maximumBit) - 1;
        for(int i = 0; i < n; i++) {
            ans[i] = pre[n-i] ^ mask;
        }
        return ans;
    }
}