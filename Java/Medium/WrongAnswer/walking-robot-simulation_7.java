class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int x = 0;
        int y = 0;
        int direction = 0;
        int max = 0;
        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 1) % 4;
            } else if (command == -1) {
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextX = x + (direction == 1 ? 1 : direction == 3 ? -1 : 0);
                    int nextY = y + (direction == 0 ? 1 : direction == 2 ? -1 : 0);
                    boolean stop = false;
                    for (int[] obstacle : obstacles) {
                        if (obstacle[0] == nextX && obstacle[1] == nextY) {
                            stop = true;
                            break;
                        }
                    }
                    if (stop) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    max = Math.max(max, x * x + y * y);
                }
            }
        }
        return max;
    }
}