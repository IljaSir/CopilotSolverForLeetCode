class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int x = 0, y = 0, d = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Long> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(((long) obstacle[0] + 30000) * 60001 + ((long) obstacle[1] + 30000));
        }
        int res = 0;
        for (int command : commands) {
            if (command == -2) {
                d = (d + 3) % 4;
            } else if (command == -1) {
                d = (d + 1) % 4;
            } else {
                for (int k = 0; k < command; k++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    if (!set.contains(((long) nx + 30000) * 60001 + ((long) ny + 30000))) {
                        x = nx;
                        y = ny;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }
}