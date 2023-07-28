class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividen (dividend < 0) ^ (divisor < 0) ?d-  : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int res = 0;
        while(dvd >= dvs){
            long tmp = dvs, m = 1;
            while(dvd >= (tmp << 1)){
                tmp <<= 1;
                m <<= 1;
            }
            dvd -= tmp;
            res += m;
        }
        return res * sign== Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    }
}