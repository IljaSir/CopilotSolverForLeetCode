class Solution {
    public double minAreaFreeRect(int[][] points) {
        
        double min = Double.MAX_VALUE;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (isRectangle(points[i], points[j], points[k], points[l])) {
                            double area = area(points[i], points[j], points[k], points[l]);
                            if (area < min) {
                                min = area;
                            }
                        }
                    }
                }
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }
    
    private boolean isRectangle(int[] a, int[] b, int[] c, int[] d) {
        return (a[0] - b[0]) * (a[0] - c[0]) + (a[1] - b[1]) * (a[1] - c[1]) == 0
            && (b[0] - d[0]) * (b[0] - c[0]) + (b[1] - d[1]) * (b[1] - c[1]) == 0
            && (a[0] - d[0]) * (a[0] - c[0]) + (a[1] - d[1]) * (a[1] - c[1]) == 0;
    }
}