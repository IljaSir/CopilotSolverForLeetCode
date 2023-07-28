class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int count = 0;
        for (int i = 0; i < circles.length; i++) {
            int[] circle = circles[i];
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            for (int j = x - r; j <= x + r; j++) {
                for (int k = y - r; k <= y + r; k++) {
                    if (j >= 0 && k >= 0 && (j != x || k != y) && Math.sqrt(Math.pow(j - x, 2) + Math.pow(k - y, 2)) <= r) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}