class Solution {
    public int orangesRotting(int[][] grid) {
        
        int minutes = 0;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for(int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.add(new int[]{x,y});
                    fresh--;
                }
            }
            minutes++;
        }
        if(fresh == 0) {
            return minutes > 0 ? minutes - 1 : 0;
        }
        return -1;
    }
}