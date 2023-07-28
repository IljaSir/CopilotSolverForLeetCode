class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left = 0, right = 0;
        int max = 0;
        int count = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            right++;
            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}