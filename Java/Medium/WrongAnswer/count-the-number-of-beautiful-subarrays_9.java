class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (nums[i] & 1);
            odd[sum]++;
        }
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += (long)odd[i] * (odd[i] - 1) / 2;
        }
        return ans;
    }
}