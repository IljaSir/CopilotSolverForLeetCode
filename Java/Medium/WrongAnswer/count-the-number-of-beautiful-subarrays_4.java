class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] pre = new int[n + 1];
        pre[0] = 1;
        int odd = 0;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            ans += pre[odd];
            pre[odd]++;
        }
        return ans;
    }
}