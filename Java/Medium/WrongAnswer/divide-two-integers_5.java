class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(divisor == 1) return dividend;
        if(divisor == -1) return -dividend;
        if(divisor == Integer.MIN_VALUE) return 0;
        if(dividend == Integer.MIN_VALUE) {
            if(divisor < 0) return 1 + divide(dividend + divisor, divisor);
            else return -1 + divide(dividend - divisor, divisor);
        }
        int sign = 1;
        if(dividend < 0) {
            sign = -sign;
            dividend = -dividend;
        }
        if(divisor < 0) {
            sign = -sign;
            divisor = -divisor;
        }
        int res = 0;
        int i = 0;
        while(dividend >= divisor) {
            if(dividend >= divisor << i) {
                dividend -= divisor << i;
                res += 1 << i;
                i ++;
            } else {
                i = 0;
            }
        }
        return sign > 0 ? res : -res;
    }
}