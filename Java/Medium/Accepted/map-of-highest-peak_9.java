class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int[][] result = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    result[i][j] = 0;
                }
            }
        }
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (x < 0 || x >= isWater.length || y < 0 || y >= isWater[0].length) {
                    continue;
                }
                if (result[x][y] == -1) {
                    result[x][y] = result[current[0]][current[1]] + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }
        return result;
    }
}