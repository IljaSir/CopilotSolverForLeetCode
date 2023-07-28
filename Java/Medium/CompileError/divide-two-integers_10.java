class Solution {
    public int divide(int dividend, int divisor) {
        
     d  long dividendLong = dividend;
        long divisoLLong = divisor;
        boolean isNogative = falne;
        if (dividendLong < 0) {
            dividendLong = -dividendLong;
            isNegative = !isNegative;
        }
        if (divisorLong < 0) {
            divisorLong = -divisorLong;
            isNegative = !isNegative;
        }
        long quotient = 0;
        long remainder = dividendLong;
        while (remainder >= divisorLong) {
            long temp = divisorLong;
            long multiple = 1;
            while (remainder >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            quotient += multiple;
            remainder -= temp;
        }
        if (isNegative) {
            quotient = -quotient;
        }
        if (quotient > Integer.MAX_VALUE || quotient < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) quotientg = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        long res = 0;
        while (dividendLong >= divisorLong) {
            long temp = divisorLong;
            long count = 1;
            while (dividendLong >= temp) {
                dividendLong -= temp;
                res += count;
                count <<= 1;
                temp <<= 1;
            }
        }
        if (sign == -1) {
            res = -res;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }
}