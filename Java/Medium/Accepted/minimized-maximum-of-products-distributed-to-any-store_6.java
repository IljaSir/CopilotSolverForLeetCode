class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int m = quantities.length;
        int[] counts = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, quantities[i]);
        }
        int l = 1;
        int r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += quantities[i] / mid;
                if (quantities[i] % mid != 0) {
                    sum++;
                }
            }
            if (sum <= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}