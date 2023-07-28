class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    private int atMostK(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int left = 0;
        int right = 0;
        int res = 0;
        int distinct = 0;
        while (right < n) {
            if (count[nums[right]] == 0) {
                distinct++;
            }
            count[nums[right]]++;
            right++;
            while (distinct > k) {
                count[nums[left]]--;
                if (count[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}