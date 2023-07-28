class Solution {
    public long smallestNumber(long num) {
        
        long result = 0;
        long temp = 0;
        long count = 0;
        long sign = 1;
        if (num < 0) {
            sign = -1;
            num *= -1;
        }
        while (num > 0) {
            temp = num % 10;
            num /= 10;
            result += temp * (long)Math.pow(10, count);
            count++;
        }
        return result * sign;
    }
}