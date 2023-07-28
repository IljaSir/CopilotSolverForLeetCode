class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int x = 0;
        int y = 0;
        int direction = 0;
        int max = 0;
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    if (!set.contains(nx + "," + ny)) {
                        x = nx;
                        y = ny;
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