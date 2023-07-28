class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length;
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = darts[i], p2 = darts[j];
                double d = Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
                if (d > 2 * r) continue;
                double[] center = getCenter(p1, p2, r);
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    int[] p = darts[k];
                    if (Math.sqrt((p[0] - center[0]) * (p[0] - center[0]) + (p[1] - center[1]) * (p[1] - center[1])) <= r + 1e-6) cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}