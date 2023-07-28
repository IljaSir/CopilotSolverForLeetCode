class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        long res = 0;
        int maxPens = total / cost1;
        for (int pens = 0; pens <= maxPens; pens++) {
            int pencils = (total - pens * cost1) / cost2;
            if (pens * cost1 + pencils * cost2 == total) {
                res += getCombinations(pens + pencils, pens);
            }
        }
        return res;
    }
    
    private long getCombinations(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}