class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long result = 0;
        while (n > 0) {
            long digit = n % 10;
            if (digit > target) {
                result += (10 - digit);
                n += (10 - digit);
            }
            n /= 10;
        }
        return result;
    }
}