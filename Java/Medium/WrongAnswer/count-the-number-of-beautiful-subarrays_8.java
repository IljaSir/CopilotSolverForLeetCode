class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        return count(nums, 1) - count(nums, 0);
    }
    private long count(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        int count = 0;
        for (int l = 0, r = 0; r < n; r++) {
            count += nums[r] & 1;
            while (count > k) {
                count -= nums[l++] & 1;
            }
            res += r - l + 1;
        }
        return res;
    }
}