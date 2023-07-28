class Solution {
    public int containVirus(int[][] isInfected) {
        
        int m = isInfected.length;
        int n = isInfected[0].length;
        int res = 0;
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        while (true) {
            int[][] walls = new int[m][n];
            int[][] areas = new int[m][n];
            int[][] frontiers = new int[m][n];
            int t = 0;
            boolean stop = true;
            for (int r = 0; r < m; ++r)
                for (int c = 0; c < n; ++c)
                    if (isInfected[r][c] == 1 && areas[r][c] == 0) {
                        stop = false;
                        Queue<int[]> queue = new LinkedList();
                        queue.add(new int[]{r, c});
                        areas[r][c] = t + 1;
                        while (!queue.isEmpty()) {
                            int[] node = queue.poll();
                            int R = node[0], C = node[1];
                            for (int k = 0; k < 4; ++k) {
                                int r1 = R + dr[k], c1 = C + dc[k];
                                if (0 <= r1 && r1 < m && 0 <= c1 && c1 < n) {
                                    if (isInfected[r1][c1] == 1 && areas[r1][c1] == 0) {
                                        areas[r1][c1] = t + 1;
                                        queue.add(new int[]{r1, c1});
                                    }
                                    if (isInfected[r1][c1] == 0)
                                        frontiers[r1][c1] = t + 1;
                                }
                            }
                        }
                        t++;
                    }
            if (stop) break;
            int[] area = new int[t];
            for (int r = 0; r < m; ++r)
                for (int c = 0; c < n; ++c)
                    if (areas[r][c] > 0)
                        area[areas[r][c] - 1]++;
            int[] frontier = new int[t];
            for (int r = 0; r < m; ++r)
                for
    }
}