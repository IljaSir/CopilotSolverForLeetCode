class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int x = 0, y = 0, direction = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> set = new HashSet<String>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int res = 0;
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    if (!set.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        res = Math.max(res, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}