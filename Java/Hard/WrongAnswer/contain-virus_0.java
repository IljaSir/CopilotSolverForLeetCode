class Solution {
    public int containVirus(int[][] isInfected) {
        
        int m = isInfected.length;
        int n = isInfected[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int res = 0;
        while (true) {
            int max = 0;
            int[][] walls = new int[m][n];
            int[][] areas = new int[m][n];
            int[][] infect = new int[m][n];
            int id = 2;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && areas[i][j] == 0) {
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i, j});
                        areas[i][j] = id;
                        int count = 0;
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            count++;
                            for (int[] dir : dirs) {
                                int x = cur[0] + dir[0];
                                int y = cur[1] + dir[1];
                                if (x >= 0 && x < m && y >= 0 && y < n && areas[x][y] == 0) {
                                    if (isInfected[x][y] == 0) {
                                        walls[x][y]++;
                                        max = Math.max(max, walls[x][y]);
                                        infect[x][y] = id;
                                    } else {
                                        areas[x][y] = id;
                                        q.offer(new int[]{x, y});
                                    }
                                }
                            }
                        }
                        id++;
                    }
                }
            }
            if (max == 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (infect[i][j] != 0 && walls[i][j] == max) {
                        isInfected[i][j] = 1;
                    }
                    if (walls[i][j] == max) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}