class Solution {
    public int countLatticePoints(int[][] circles) {
        
        int result = 0;
        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            int r2 = r * r;
            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {
                    if ((x - i) * (x - i) + (y - j) * (y - j) <= r2) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}