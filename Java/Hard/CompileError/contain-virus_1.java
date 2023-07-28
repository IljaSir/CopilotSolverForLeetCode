class Solution {
    public int containVirus(int[][] isInfected) {
        
        int m = isInfected.length;
        int n = isInfected[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (true) {
            int[][] walls = new int[m][n];
            int[][] regions = new int[m][n];
            int region = 0;
            int[] area = new int[m * n];
            int[] perimeters = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1 && regions[i][j] == 0) {
                        area[region] = 1;
                        regions[i][j] = region + 1;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            for (int[] dir : dirs) {
                                int x = cur[0] + dir[0];
                                int y = cur[1] + dir[1];
                                if (x >= 0 && x < m && y >= 0 && y < n && isInfected[x][y] == 1 && regions[x][y] == 0) {
                                    area[region]++;
                                    regions[x][y] = region + 1;
                                    queue.offer(new int[]{x, y});
                                }
                            }
                        }
                        for (int[] cur : queue) {
                            for (int[] dir : dirs) {
                                int x = cur[0] + dir[0];
                                int y = cur[1] + dir[1];
                                if (x >= 0 && x < m && y >= 0 && y < n && isInfected[x][y] == 0) {
                                    walls[x][y]++;
                                    perimeters[region] = Math.max(perimeters[region], walls[x][y]);
                                }
                            }
                        }
                        region++;
                    }
                }
            }
            if (region == 0) {
                break;
            }
            int maxArea = 0;
            int maxRegion = 0;
            for (int i =
    }
}