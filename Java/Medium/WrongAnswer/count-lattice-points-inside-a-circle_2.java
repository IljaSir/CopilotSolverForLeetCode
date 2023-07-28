class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int result = 0;
        for (int i = 0; i < circles.length; i++) {
            int[] circle = circles[i];
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            int x1 = x - r;
            int x2 = x + r;
            int y1 = y - r;
            int y2 = y + r;
            int count = 0;
            for (int j = 0; j < circles.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] circle2 = circles[j];
                int x3 = circle2[0];
                int y3 = circle2[1];
                int r2 = circle2[2];
                if (x3 >= x1 && x3 <= x2 && y3 >= y1 && y3 <= y2) {
                    count++;
                }
            }
            result += 4 * r - 4 * count;
        }
        return result;
    }
}