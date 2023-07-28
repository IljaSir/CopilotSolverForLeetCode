class Solution {
    public double minAreaFreeRect(int[][] points) {
        
        Set<String> set = new HashSet<>();
        for (int[] point : points) {
            set.add(point[0] + "," + point[1]);
        }
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    int[] p4 = new int[]{p1[0] + p2[0] - p3[0], p1[1] + p2[1] - p3[1]};
                    if (set.contains(p4[0] + "," + p4[1])) {
                        ans = Math.min(ans, Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1])) * Math.sqrt((p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1])));
                    }
                }
            }
        }
        return ans == Double.MAX_VALUE ? 0 : ans;
    }
}