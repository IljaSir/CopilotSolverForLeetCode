class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int[] p1 = coordinates[0];
        int[] p2 = coordinates[1];
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];
        int dx = x2 - x1;
        int dy = y2 - y1;
        for (int i = 2; i < coordinates.length; i++) {
            int[] p = coordinates[i];
            int x = p[0];
            int y = p[1];
            if (dx * (y - y2) != dy * (x - x2)) {
                return false;
            }
        }
        return true;
    }
}