class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for(int[] row : result){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] direction : directions){
                int row = cell[0] + direction[0];
                int col = cell[1] + direction[1];
                if(row >= 0 && row < m && col >= 0 && col < n){
                    if(result[row][col] > result[cell[0]][cell[1]] + 1){
                        result[row][col] = result[cell[0]][cell[1]] + 1;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }
        return result;
    }
}