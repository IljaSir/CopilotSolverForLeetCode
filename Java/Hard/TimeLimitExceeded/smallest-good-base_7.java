class Solution {
    public String smallestGoodBase(String n) {
        
        long num = Long.parseLong(n);
        long max = (long) Math.pow(num, 1.0 / 2.0);
        for (long i = max; i >= 2; i--) {
            long base = (long) Math.pow(num, 1.0 / i);
            long sum = 0;
            for (int j = 0; j <= i; j++) {
                sum = sum * base + 1;
            }
            if (sum == num) {
                return String.valueOf(base);
            }
        }
        return String.valueOf(num - 1);
    }
}