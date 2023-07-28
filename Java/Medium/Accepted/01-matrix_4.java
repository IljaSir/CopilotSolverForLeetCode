class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = curr[0] + dir[i][0];
                int y = curr[1] + dir[i][1];
                if(x >= 0 && x < m && y >= 0 && y < n && mat[x][y] > mat[curr[0]][curr[1]] + 1){
                    mat[x][y] = mat[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return mat;
    }
}