class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                mat[x][y] = distance;
                for(int[] direction : directions){
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && mat[newX][newY] == -1){
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}