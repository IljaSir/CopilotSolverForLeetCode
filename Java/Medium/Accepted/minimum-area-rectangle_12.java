class Solution {
    public int minAreaRect(int[][] points) {
        
        int n = points.length;
        if (n < 4) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2 && set.contains(x1 + "," + y2) && set.contains(x2 + "," + y1)) {
                    ans = Math.min(ans, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}