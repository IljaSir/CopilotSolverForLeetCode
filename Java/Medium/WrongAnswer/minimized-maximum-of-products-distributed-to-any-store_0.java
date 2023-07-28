class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int m = quantities.length;
        int[] sum = new int[m];
        sum[0] = quantities[0];
        for (int i = 1; i < m; i++) {
            sum[i] = sum[i - 1] + quantities[i];
        }
        int l = 1, r = sum[m - 1];
        while (l < r) {
            int mid = (l + r) / 2;
            int k = 0;
            for (int i = 0; i < m; i++) {
                k += sum[i] / mid;
            }
            if (k >= n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }
}