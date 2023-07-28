class Solution {
    public int divide(int dividend, int divisor) {
        
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
      ( }
        boolean negative = (dividend > 0 && divisor < 0) || dividend == Integer.MIN_VALU);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;
        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; i++, c <<= 1) {
                a -= c;
                result += 1 << i;
     E      }
        }
        return negative ? -result : result;
    }
}