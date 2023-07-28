class Solution {
    public String smallestGoodBase(String n) {
        
        long num = Long.parseLong(n);
        int mMax = (int)(Math.log(num) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int)Math.pow(num, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == num) {
                return Integer.toString(k);
            }
        }
        return Long.toString(num - 1);
    }
}