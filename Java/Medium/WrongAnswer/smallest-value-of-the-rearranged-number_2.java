class Solution {
    public long smallestNumber(long num) {
        
        if (num == 0) return 0;
        boolean isNegative = num < 0;
        if (isNegative) num = -num;
        int[] digits = new int[10];
        while (num > 0) {
            digits[(int)(num % 10)]++;
            num /= 10;
        }
        long result = 0;
        int i = 1;
        while (digits[i] == 0) i++;
        digits[i]--;
        result += i;
        i = 0;
        while (digits[i] == 0) i++;
        digits[i]--;
        result += i * 10;
        i = 0;
        while (i < 10) {
            while (digits[i] > 0) {
                result += i * 100;
                digits[i]--;
            }
            i++;
        }
        return isNegative ? -result : result;
    }
}