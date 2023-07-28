class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long sum = 0;
        long res = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum * (i - left + 1) >= k) {
                sum -= nums[left++];
            }
            res += i - left + 1;
        }
        return res;
    }
}