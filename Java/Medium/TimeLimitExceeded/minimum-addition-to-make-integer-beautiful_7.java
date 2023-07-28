class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long sum = 0;
        long x = 1;
        while (n > 0) {
            long digit = n % 10;
            sum += digit;
            n = n / 10;
            if (sum > target) {
                sum -= digit;
                sum += 10;
                n += 1;
            }
        }
        return sum - target;
    }
}