class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int oneCount = 0;
        for (int num : nums) {
            if (num == 1) {
                oneCount++;
            }
        }
        int maxOnes = 0;
        int windowOnes = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] == 1) {
                windowOnes++;
            }
            right++;
            if (right - left > oneCount) {
                if (nums[left] == 1) {
                    windowOnes--;
                }
                left++;
            }
            maxOnes = Math.max(maxOnes, windowOnes);
        }
        return oneCount - maxOnes;
    }
}