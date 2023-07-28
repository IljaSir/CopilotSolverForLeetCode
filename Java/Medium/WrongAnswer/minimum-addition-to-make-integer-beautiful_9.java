class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long result = 0;
        long sum = 0;
        long[] digits = new long[20];
        int len = 0;
        while (n > 0) {
            digits[len++] = n % 10;
            n /= 10;
        }
        for (int i = len - 1; i >= 0; i--) {
            sum += digits[i];
            if (sum <= target) {
                continue;
            }
            long diff = sum - target;
            long add = (10 - digits[i]);
            digits[i] += add;
            result += add;
            sum -= diff;
        }
        return result;
    }
}