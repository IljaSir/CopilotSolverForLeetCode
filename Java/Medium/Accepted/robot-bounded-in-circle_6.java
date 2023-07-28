class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, di = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'L') {
                di = (di + 3) % 4;
            } else if (ch == 'R') {
                di = (di + 1) % 4;
            } else {
                x += dir[di][0];
                y += dir[di][1];
            }
        }
        return (x == 0 && y == 0) || di > 0;
    }
}