class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(i * n + j);
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int current = queue.poll();
                int currentX = current / n;
                int currentY = current % n;
                for(int[] direction : directions){
                    int nextX = currentX + direction[0];
                    int nextY = currentY + direction[1];
                    if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || grid[nextX][nextY] != 1){
                        continue;
                    }
                    grid[nextX][nextY] = 2;
                    queue.offer(nextX * n + nextY);
                    fresh--;
                }
            }
            step++;
        }
        return fresh == 0 ? step - 1 : -1;
    }
}