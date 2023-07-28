class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int ans = 1;
        int n = darts.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] center = getCenter(darts[i], darts[j], r);
                if (center == null) {
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (isInCircle(darts[k], center, r)) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    private boolean isInCircle(int[] dart, double[] center, int r) {
        return Math.pow(dart[0] - center[0], 2) + Math.pow(dart[1] - center[1], 2) <= r * r;
    }

    private double[] getCenter(int[] dart1, int[] dart2, int r) {
        double dis = Math.sqrt(Math.pow(dart1[0] - dart2[0], 2) + Math.pow(dart1[1] - dart2[1], 2));
        if (dis > 2 * r) {
            return null;
        }
        double[] center = new double[2];
        center[0] = (dart1[0] + dart2[0]) / 2.0;
        center[1] = (dart1[1] + dart2[1]) / 2.0;
        double angle = Math.atan2(dart2[1] - dart1[1], dart2[0] - dart1[0]);
        double offset = Math.acos(dis / 2 / r);
        double[] res = new double[2];
        res[0] = center[0] + r * Math.cos(angle + offset);
        res[1] = center[1] + r * Math.sin(angle + offset);
        if (isInCircle(dart1, res, r) && isInCircle(dart2, res, r)) {
            return res;
        }
        res[0] = center[0] + r * Math.cos(angle - offset);
        res[1] = center[1] + r * Math.sin(angle - offset);
    }
}