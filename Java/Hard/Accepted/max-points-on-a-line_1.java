class Solution {
    public int maxPoints(int[][] points) {
        
        if (points.length <= 2) {
            return points.length;
        }
        int max = 2;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int count = 2;
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    if ((x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1)) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}