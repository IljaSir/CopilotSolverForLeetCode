class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int startColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr,sc});
        visited[sr][sc] = true;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int[] direction : directions){
                int x = point[0]+direction[0];
                int y = point[1]+direction[1];
                if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && image[x][y]==startColor){
                    queue.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
            image[point[0]][point[1]] = color;
        }
        return image;
    }
}