class Solution {
    public int differenceOfSum(int[] nums) {
        
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            sum2 += getDigitSum(nums[i]);
        }
        return Math.abs(sum1 - sum2);
    }
    
    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}