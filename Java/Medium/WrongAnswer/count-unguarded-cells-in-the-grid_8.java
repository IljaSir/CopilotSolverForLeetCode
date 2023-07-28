class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        Set<Integer> wallSet = new HashSet<>();
        for (int[] wall : walls) {
            wallSet.add(wall[0] * n + wall[1]);
        }
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean guarded = false;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    while (x >= 0 && x < m && y >= 0 && y < n) {
                        if (wallSet.contains(x * n + y)) {
                            break;
                        }
                        for (int[] guard : guards) {
                            if (guard[0] == x && guard[1] == y) {
                                guarded = true;
                                break;
                            }
                        }
                        if (guarded) {
                            break;
                        }
                        x += dir[0];
                        y += dir[1];
                    }
                    if (guarded) {
                        break;
                    }
                }
                if (!guarded) {
                    count++;
                }
            }
        }
        return count;
    }
}