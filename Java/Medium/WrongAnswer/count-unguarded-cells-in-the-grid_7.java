class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int ans = 0;
        boolean[][] seen = new boolean[m][n];
        for (int[] guard : guards) {
            seen[guard[0]][guard[1]] = true;
        }
        for (int[] wall : walls) {
            seen[wall[0]][wall[1]] = true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seen[i][j]) {
                    continue;
                }
                ans++;
                seen[i][j] = true;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    if (x - 1 >= 0 && !seen[x - 1][y]) {
                        seen[x - 1][y] = true;
                        q.offer(new int[]{x - 1, y});
                    }
                    if (y - 1 >= 0 && !seen[x][y - 1]) {
                        seen[x][y - 1] = true;
                        q.offer(new int[]{x, y - 1});
                    }
                    if (x + 1 < m && !seen[x + 1][y]) {
                        seen[x + 1][y] = true;
                        q.offer(new int[]{x + 1, y});
                    }
                    if (y + 1 < n && !seen[x][y + 1]) {
                        seen[x][y + 1] = true;
                        q.offer(new int[]{x, y + 1});
                    }
                }
            }
        }
        return ans;
    }
}