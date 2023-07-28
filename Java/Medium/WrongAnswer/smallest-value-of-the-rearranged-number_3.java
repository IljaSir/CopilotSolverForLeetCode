class Solution {
    public long smallestNumber(long num) {
        
        if (num == 0) return 0;
        long sign = num < 0 ? -1 : 1;
        num = Math.abs(num);
        int[] digits = new int[10];
        while (num > 0) {
            digits[(int)(num % 10)]++;
            num /= 10;
        }
        long res = 0;
        for (int i = 1; i < 10; i++) {
            while (digits[i] > 0) {
                res = res * 10 + i;
                digits[i]--;
            }
        }
        while (digits[0] > 0) {
            res = res * 10;
            digits[0]--;
        }
        return res * sign;
    }
}