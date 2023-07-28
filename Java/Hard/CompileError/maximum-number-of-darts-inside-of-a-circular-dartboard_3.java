class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length;
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int[] a = darts[i], b = darts[j];
                if (dist(a, b) > 4 * r * r) continue;
                int[] c = circumcenter(a, b, r);
                int cnt = 0;
                for (int k = 0; k < n; ++k) {
                    if (dist(c, darts[k]) <= r * r) ++cnt;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
    
    private int dist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}