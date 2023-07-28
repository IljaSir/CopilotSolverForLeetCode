class Solution {
    public double minAreaFreeRect(int[][] points) {
        
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }
        double res = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];
                    int[] p4 = new int[]{p1[0] + p2[0] - p3[0], p1[1] + p2[1] - p3[1]};
                    if (!set.contains(p4[0] + "," + p4[1])) {
                        continue;
                    }
                    double d1 = dist(p1, p2), d2 = dist(p1, p3);
                    if (d1 == 0 || d2 == 0) {
                        continue;
                    }
                    if (d1 == d2) {
                        res = Math.min(res, d1 * dist(p2, p3));
                    } else if (d1 == dist(p2, p3)) {
                        res = Math.min(res, d1 * d2);
                    } else if (d2 == dist(p1, p2)) {
                        res = Math.min(res, d1 * d2);
                    }
                }
            }
        }
        return res == Double.MAX_VALUE ? 0 : res;
    }
}