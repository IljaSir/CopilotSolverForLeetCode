class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        if (coordinates.length == 2) {
            return true;
        }
        int[] p1 = coordinates[0];
        int[] p2 = coordinates[1];
        for (int i = 2; i < coordinates.length; i++) {
            int[] p3 = coordinates[i];
            if ((p2[1] - p1[1]) * (p3[0] - p2[0]) != (p3[1] - p2[1]) * (p2[0] - p1[0])) {
                return false;
            }
        }
        return true;
    }
}