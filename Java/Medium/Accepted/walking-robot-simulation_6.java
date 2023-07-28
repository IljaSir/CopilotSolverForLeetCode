class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int x = 0;
        int y = 0;
        int direction = 0;
        int max = 0;
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle: obstacles) {
            obstacleSet.add(obstacle[0] + " " + obstacle[1]);
        }
        for (int command: commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextX = x;
                    int nextY = y;
                    if (direction == 0) {
                        nextY++;
                    } else if (direction == 1) {
                        nextX++;
                    } else if (direction == 2) {
                        nextY--;
                    } else if (direction == 3) {
                        nextX--;
                    }
                    if (!obstacleSet.contains(nextX + " " + nextY)) {
                        x = nextX;
                        y = nextY;
                        max = Math.max(max, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return max;
    }
}