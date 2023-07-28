class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, di = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                di = (di + 3) % 4;
            } else if (c == 'R') {
                di = (di + 1) % 4;
            } else {
                x += dirs[di][0];
                y += dirs[di][1];
            }
        }
        return (x == 0 && y == 0) || di > 0;
    }
}