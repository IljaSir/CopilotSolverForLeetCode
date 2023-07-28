class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = darts[i];
                int[] p2 = darts[j];
                int[] center = getCenter(p1, p2, r);
                if (center == null) continue;
                for (int k = 0; k < n; k++) {
                    if (getDist(center, darts[k]) <= r * r) {
                        res[i]++;
                        res[j]++;
                        res[k]++;
                    }
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) ans = Math.max(ans, res[i]);
        return ans;
    }
    private int[] getCenter(int[] p1, int[] p2, int r) {
        double d = getDist(p1, p2);
        if (d > 4 * r * r) return null;
        double midx = (p1[0] + p2[0]) / 2.0;
        double midy = (p1[1] + p2[1]) / 2.0;
        double dx = (p2[1] - p1[1]) * Math.sqrt((4 * r * r - d) / d);
        double dy = (p2[0] - p1[0]) * Math.sqrt((4 * r * r - d) / d);
        return new int[]{(int) (midx + dx), (int) (midy - dy)};
    }
}