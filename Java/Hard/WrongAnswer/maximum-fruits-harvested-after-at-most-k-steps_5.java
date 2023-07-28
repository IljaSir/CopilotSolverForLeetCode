class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + fruits[i][1];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (fruits[m][0] - fruits[i][0] <= k) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (l > i) {
                int t = sum[l] - sum[i] + Math.min(k, fruits[l - 1][0] - fruits[i][0]);
                if (fruits[l - 1][0] - fruits[i][0] >= k) {
                    t -= fruits[l - 1][1];
                }
                res = Math.max(res, t);
            }
        }
        return res;
    }
}