class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = max; i >= 0; i--) {
            int sum = 0;
            for (int j = i; j <= max; j += i) {
                sum += count[j];
            }
            if (sum == numsDivide.length) {
                return nums.length - sum;
            }
        }
        return -1;
    }
}