class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    public int atMostK(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int[] freq = new int[nums.length + 1];
        while (right < nums.length) {
            if (freq[nums[right]] == 0) {
                k--;
            }
            freq[nums[right]]++;
            right++;
            while (k < 0) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    k++;
                }
                left++;
            }
            count += right - left;
        }
        return count;
    }
}