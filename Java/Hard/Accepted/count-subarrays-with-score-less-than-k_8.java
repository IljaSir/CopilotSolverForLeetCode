class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long result = 0;
        int left = 0;
        int right = 0;
        long sum = 0L;
        long len = 0L;
        while (right < nums.length) {
            sum += nums[right];
            len += 1;
            while (sum * len >= k) {
                sum -= nums[left];
                len -= 1;
                left++;
            }
            result += len;
            right++;
        }
        return result;
    }
}