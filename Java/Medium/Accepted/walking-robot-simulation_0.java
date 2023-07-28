class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + " " + obstacle[1]);
        }
        int x = 0, y = 0, direction = 0;
        int ans = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                direction = (direction + 3) % 4;
            } else if (cmd == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + directions[direction][0];
                    int ny = y + directions[direction][1];
                    if (!obstacleSet.contains(nx + " " + ny)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
}