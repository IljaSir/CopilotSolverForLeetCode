class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        Set<Long> set = new HashSet<>();
        for (int[] obstacle: obstacles) {
            long ox = (long)obstacle[0] + 30000;
            long oy = (long)obstacle[1] + 30000;
            set.add((ox << 16) + oy);
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, di = 0;
        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dirs[di][0];
                    int ny = y + dirs[di][1];
                    long code = (((long)nx + 30000) << 16) + ((long)ny + 30000);
                    if (!set.contains(code)) {
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