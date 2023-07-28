class Solution {
    public String smallestGoodBase(String n) {
        
        long num = Long.parseLong(n);
        int max = (int)(Math.log(num) / Math.log(2));
        for (int m = max; m >= 2; m--) {
            long k = (long)Math.pow(num, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 1; i <= m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == num) {
                return Long.toString(k);
            }
        }
        return Long.toString(num - 1);
    }
}