class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int[] coordinate : coordinates) {
            if (coordinate[0] == x1 && coordinate[1] == y1) {
                continue;
            }
            if ((coordinate[1] - y1) * (x2 - x1) != (coordinate[0] - x1) * (y2 - y1)) {
                return false;
            }
        }
        return true;
    }
}