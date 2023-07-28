class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long score = 0;
        long count = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            score += nums[right];
            while (score >= k && left <= right) {
                score -= nums[left++];
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}