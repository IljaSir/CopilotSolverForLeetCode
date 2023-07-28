class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int oddSum = 0;
        int evenSum = 0;
        int[] oddSums = new int[nums.length];
        int[] evenSums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
                evenSums[i] = evenSum;
            } else {
                oddSum += nums[i];
                oddSums[i] = oddSum;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int leftOdd = i == 0 ? 0 : oddSums[i - 1];
            int rightOdd = oddSum - oddSums[i];
            int leftEven = i == 0 ? 0 : evenSums[i - 1];
            int rightEven = evenSum - evenSums[i];
            if (leftOdd + rightEven == leftEven + rightOdd) {
                count++;
            }
        }
        return count;
    }
}