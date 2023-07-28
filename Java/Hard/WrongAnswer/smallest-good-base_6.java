class Solution {
    public String smallestGoodBase(String n) {
        
        long num = Long.parseLong(n);
        long res = Long.MAX_VALUE;
        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m >= 2; m--) {
            long k = (long) Math.pow(num, 1.0 / (m - 1));
            long mul = 1, sum = 1;
            for (int i = 1; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == num) {
                res = Math.min(res, k);
            }
        }
        return Long.toString(res);
    }
}