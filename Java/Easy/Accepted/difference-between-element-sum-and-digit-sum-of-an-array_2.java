class Solution {
    public int differenceOfSum(int[] nums) {
        
        int elementSum = 0;
        int digitSum = 0;
        for (int i = 0; i < nums.length; i++) {
            elementSum += nums[i];
            digitSum += getDigitSum(nums[i]);
        }
        return Math.abs(elementSum - digitSum);
    }
    
    public int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}