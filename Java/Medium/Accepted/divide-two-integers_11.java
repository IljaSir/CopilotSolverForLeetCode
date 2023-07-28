class Solution {
    public int divide(int dividend, int divisor) {
        
        long dividendLong = dividend;
        long divisorLong = divisor;
        boolean isNegative = false;
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
        return (int) quotient;
    }
}