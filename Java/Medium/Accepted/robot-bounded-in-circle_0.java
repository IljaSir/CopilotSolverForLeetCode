class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int x = 0, y = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'L') {
                idx = (idx + 3) % 4;
            } else if (ch == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }
        return (x == 0 && y == 0) || idx != 0;
    }
}