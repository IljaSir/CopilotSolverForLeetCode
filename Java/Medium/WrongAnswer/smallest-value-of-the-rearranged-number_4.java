class Solution {
    public long smallestNumber(long num) {
        
        long[] arr = new long[10];
        long sign = 1;
        if (num < 0) {
            sign = -1;
            num = -num;
        }
        while (num > 0) {
            long digit = num % 10;
            arr[(int)digit]++;
            num /= 10;
        }
        long ans = 0;
        long base = 1;
        for (int i = 0; i < 10; i++) {
            while (arr[i] > 0) {
                ans = ans + i * base;
                base *= 10;
                arr[i]--;
            }
        }
        return sign * ans;
    }
}