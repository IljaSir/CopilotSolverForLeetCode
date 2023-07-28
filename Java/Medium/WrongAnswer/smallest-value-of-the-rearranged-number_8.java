class Solution {
    public long smallestNumber(long num) {
        
        long res = 0;
        long sign = 1;
        if (num < 0) {
            sign = -1;
            num = -num;
        }
        int[] arr = new int[10];
        while (num > 0) {
            arr[(int)(num % 10)]++;
            num /= 10;
        }
        for (int i = 1; i < 10; i++) {
            while (arr[i]-- > 0) {
                res = res * 10 + i;
            }
        }
        while (arr[0]-- > 0) {
            res *= 10;
        }
        return res * sign;
    }
}