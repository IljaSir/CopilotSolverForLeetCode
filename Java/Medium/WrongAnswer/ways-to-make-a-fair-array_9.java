class Solution {
    public int waysToMakeFair(int[] nums) {
        
        // 1. get sum of odd and even
        // 2. remove one by one
        int evenSum = 0, oddSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum -= nums[i];
            } else {
                oddSum -= nums[i];
            }
            if (evenSum == oddSum) {
                result++;
            }
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        return result;
    }
}