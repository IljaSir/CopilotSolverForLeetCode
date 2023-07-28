class Solution {
    public int maximumSum(int[] nums) {
        
        int[] digits = new int[91];
        for (int num : nums) {
            digits[sumOfDigits(num)] = Math.max(digits[sumOfDigits(num)], num);
        }
        int maxSum = -1;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (i != j && digits[i] > 0 && digits[j] > 0) {
                    maxSum = Math.max(maxSum, digits[i] + digits[j]);
                }
            }
        }
        return maxSum;
    }
    
    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}