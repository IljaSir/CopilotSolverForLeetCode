class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int left = 0, right = 0, oddCount = 0, result = 0;
        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                oddCount++;
            }
            right++;
            if (oddCount == k) {
                int temp = right;
                while (right < nums.length && nums[right] % 2 == 0) {
                    right++;
                }
                int rightEvenCount = right - temp;
                int leftEvenCount = 0;
                while (nums[left] % 2 == 0) {
                    left++;
                    leftEvenCount++;
                }
                result += (leftEvenCount + 1) * (rightEvenCount + 1);
                left++;
                oddCount--;
            }
        }
        return result;
    }
}