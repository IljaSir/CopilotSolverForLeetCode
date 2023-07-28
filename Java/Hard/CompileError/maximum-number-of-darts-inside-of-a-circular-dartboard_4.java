class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length;
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int[] p1 = darts[i];
                int[] p2 = darts[j];
                int[] center = getCenter(p1, p2, r);
                if (center == null) {
                    continue;
                }
                int cnt = 0;
                for (int[] p : darts) {
                    if (dist(p, center) <= r * r) {
                        ++cnt;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    private int[] getCenter(int[] p1, int[] p2, int r) {
        int d2 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d = (int) Math.sqrt(d2);
        if (d > 2 * r) {
            return null;
        }
        double midx = (p1[0] + p2[0]) / 2.0;
        double midy = (p1[1] + p2[1]) / 2.0;
        double a = Math.sqrt(r * r - d * d / 4.0);
        double dx = (p1[1] - p2[1]) * a / d;
        double dy = (p2[0] - p1[0]) * a / d;
        return new int[]{(int) (midx + dx), (int) (midy + dy)};
    }
}