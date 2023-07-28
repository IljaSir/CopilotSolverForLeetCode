class Solution {
    public long smallestNumber(long num) {
        
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        long[] digits = new long[10];
        while (num > 0) {
            long digit = num % 10;
            digits[(int) digit]++;
            num /= 10;
        }
        long result = 0;
        for (int i = 0; i < 10; i++) {
            while (digits[i]-- > 0) {
                result = result * 10 + i;
            }
        }
        if (isNegative) {
            result = -result;
        }
        return result;
    }
}