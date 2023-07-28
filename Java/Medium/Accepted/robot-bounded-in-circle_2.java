class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int x = 0, y = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                idx = (idx + 3) % 4;
            }
            else if (c == 'R') {
                idx = (idx + 1) % 4;
            }
            else {
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
        }
        return (x == 0 && y == 0) || idx != 0;
    }
}