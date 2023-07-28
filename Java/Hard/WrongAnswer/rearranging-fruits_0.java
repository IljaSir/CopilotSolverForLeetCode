class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        
        int n = basket1.length;
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += basket1[i];
            sum2 += basket2[i];
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            int[] temp = basket1;
            basket1 = basket2;
            basket2 = temp;
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long cost = sum1 - basket1[i] + sum2 - basket2[i];
            if (cost % 2 == 0) {
                res = Math.min(res, Math.min(basket1[i], basket2[i]));
            }
        }
        return res == Long.MAX_VALUE ? -1 : res;
    }
}