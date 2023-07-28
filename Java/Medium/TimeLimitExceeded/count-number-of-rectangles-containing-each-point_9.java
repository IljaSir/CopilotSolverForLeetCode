class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] ans = new int[points.length];
        int k = 0;
        for(int[] point: points){
            int x = point[0];
            int y = point[1];
            for(int[] rectangle: rectangles){
                int lx = rectangle[0];
                int ly = rectangle[1];
                if(x <= lx && y <= ly){
                    ans[k]++;
                }
            }
            k++;
        }
        return ans;
    }
}