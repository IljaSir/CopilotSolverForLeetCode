class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int count = 0;
        int[] x = new int[101];
        int[] y = new int[101];
        for (int i = 0; i < circles.length; i++) {
            int[] circle = circles[i];
            int xi = circle[0];
            int yi = circle[1];
            int ri = circle[2];
            for (int j = xi - ri; j <= xi + ri; j++) {
                for (int k = yi - ri; k <= yi + ri; k++) {
                    if (j >= 0 && j <= 100 && k >= 0 && k <= 100) {
                        if (x[j] == 0 && y[k] == 0) {
                            count++;
                        }
                        x[j]++;
                        y[k]++;
                    }
                }
            }
        }
        return count;
    }
}