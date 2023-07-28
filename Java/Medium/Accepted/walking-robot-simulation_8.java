class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int x = 0, y = 0;
        int max = 0;
        int direction = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Long> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(((long)obstacle[0] << 32) + obstacle[1]);
        }
        for (int cmd : commands) {
            if (cmd == -1) {
                direction = (direction + 1) % 4;
            } else if (cmd == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[direction][0];
                    int ny = y + dirs[direction][1];
                    if (!set.contains(((long)nx << 32) + ny)) {
                        x = nx;
                        y = ny;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }
        return max;
    }
}