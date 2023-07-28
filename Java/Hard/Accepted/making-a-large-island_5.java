class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[] area = new int[n * n + 2];
        int index = 2;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = index;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        area[index]++;
                        for (int[] d : dir) {
                            int x = cur[0] + d[0];
                            int y = cur[1] + d[1];
                            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                                grid[x][y] = index;
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                    index++;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < index; i++) {
            res = Math.max(res, area[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) {
                            set.add(grid[x][y]);
                        }
                    }
                    int cur = 1;
                    for (int k : set) {
                        cur += area[k];
                    }
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }
}