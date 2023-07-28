class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int oddSum = 0;
        int evenSum = 0;
        int oddSum1 = 0;
        int evenSum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                oddSum += nums[i];
            } else {
                evenSum += nums[i];
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                oddSum -= nums[i];
            } else {
                evenSum -= nums[i];
            }
            if (oddSum + evenSum1 == evenSum + oddSum1) {
                count++;
            }
            if (i % 2 == 0) {
                oddSum1 += nums[i];
            } else {
                evenSum1 += nums[i];
            }
        }
        return count;
    }
}