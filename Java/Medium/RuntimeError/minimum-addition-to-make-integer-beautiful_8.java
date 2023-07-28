class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long sum = 0;
        int[] digits = new int[12];
        int len = 0;
        while (n > 0) {
            digits[len++] = (int) (n % 10);
            n /= 10;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (sum + digits[i] > target) {
                int diff = target - (int) (sum % 10);
                sum += diff;
                digits[i - 1] += 1;
            }
            sum += digits[i];
        }
        return sum - target;
    }
}