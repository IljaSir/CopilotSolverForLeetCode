class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[] nums = new int[numOnes + numZeros + numNegOnes];
        for (int i = 0; i < numOnes; i++) {
            nums[i] = 1;
        }
        for (int i = numOnes; i < numOnes + numZeros; i++) {
            nums[i] = 0;
        }
        for (int i = numOnes + numZeros; i < numOnes + numZeros + numNegOnes; i++) {
            nums[i] = -1;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            sum += nums[i];
        }
        return sum;
    }
}