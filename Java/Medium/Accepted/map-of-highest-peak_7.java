class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    res[i][j] = 0;
                    q.offer(new int[] {i, j});
                }
                else{
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x < 0 || x >= m || y < 0 || y >= n || res[x][y] != Integer.MAX_VALUE){
                    continue;
                }
                res[x][y] = res[cur[0]][cur[1]] + 1;
                q.offer(new int[] {x, y});
            }
        }
        return res;
    }
}