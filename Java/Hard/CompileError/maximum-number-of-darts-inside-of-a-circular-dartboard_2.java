class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = darts[i];
                int[] p2 = darts[j];
                double[] center = getCenter(p1, p2, r);
                if (center == null) {
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (getDistance(center, darts[k]) <= r) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    private double[] getCenter(int[] p1, int[] p2, int r) {
        double x1 = p1[0];
        double y1 = p1[1];
        double x2 = p2[0];
        double y2 = p2[1];
        double d = getDistance(p1, p2);
        if (d > 2 * r) {
            return null;
        }
        double midX = (x1 + x2) / 2;
        double midY = (y1 + y2) / 2;
        double offsetX = Math.sqrt(r * r - d * d / 4) * (y2 - y1) / d;
        double offsetY = Math.sqrt(r * r - d * d / 4) * (x1 - x2) / d;
        return new double[]{midX + offsetX, midY + offsetY};
    }

    private double getDistance(int[] p1, int[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }
}