class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long sum = 0;
        long num = n;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum <= target) {
            return 0;
        }
        long result = 0;
        long base = 1;
        while (sum > target) {
            long digit = n % 10;
            if (digit < 9) {
                result += (9 - digit) * base;
                sum += (9 - digit);
            }
            base *= 10;
            n /= 10;
        }
        return result;
    }
}