class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0){
            return 0;
        }
        int minutes = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            minutes++;
            for(int i=0;i<size;i++){
                int[] current = queue.poll();
                for(int[] direction : directions){
                    int newX = current[0] + direction[0];
                    int newY = current[1] + direction[1];
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        freshOranges--;
                        if(freshOranges == 0){
                            return minutes;
                        }
                        queue.offer(new int[]{newX,newY});
                    }
                }
            }
        }
        return -1;
    }
}