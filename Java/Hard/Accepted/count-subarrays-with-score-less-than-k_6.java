class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long sum = 0;
        long res = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        while (r < n) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }
}