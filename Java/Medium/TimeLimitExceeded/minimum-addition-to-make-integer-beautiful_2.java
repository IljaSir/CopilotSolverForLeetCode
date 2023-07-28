class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long sum = 0;
        long tmp = n;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if (sum <= target) return 0;
        long res = 0;
        long factor = 1;
        while (sum > target) {
            long digit = n % 10;
            if (digit == 9) {
                n /= 10;
                factor *= 10;
                continue;
            }
            long add = 9 - digit;
            res += add * factor;
            n += add;
            sum -= digit;
            sum += 9;
        }
        return res;
    }
}