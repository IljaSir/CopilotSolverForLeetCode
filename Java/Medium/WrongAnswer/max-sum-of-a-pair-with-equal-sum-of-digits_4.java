class Solution {
    public int maximumSum(int[] nums) {
        
        int[] digits = new int[81];
        for (int num : nums) {
            int sum = 0;
            for (int n = num; n > 0; n /= 10) {
                sum += n % 10;
            }
            digits[sum] = Math.max(digits[sum], num);
        }
        int max = -1;
        for (int i = 0; i < 81; i++) {
            for (int j = i + 1; j < 81; j++) {
                max = Math.max(max, digits[i] + digits[j]);
            }
        }
        return max;
    }
}