class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int left = 0, right = 0, count = 0, res = 0;
        int[] freq = new int[nums.length + 1];
        while (right < nums.length) {
            if (freq[nums[right]] == 0) count++;
            freq[nums[right]]++;
            right++;
            while (count > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) count--;
                left++;
            }
            res += right - left;
        }
        return res;
    }
}