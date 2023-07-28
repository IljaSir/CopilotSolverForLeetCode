class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int m = quantities.length;
        int lo = 1;
        int hi = 100000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += quantities[i] / mid;
                if (quantities[i] % mid != 0) {
                    sum++;
                }
            }
            if (sum <= n) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}