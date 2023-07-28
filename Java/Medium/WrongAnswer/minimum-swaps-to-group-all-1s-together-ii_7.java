class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }
        }
        int maxCount = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] == 1) {
                maxCount++;
            }
            if (right - left + 1 > count) {
                if (nums[left] == 1) {
                    maxCount--;
                }
                left++;
            }
            right++;
        }
        return count - maxCount;
    }
}