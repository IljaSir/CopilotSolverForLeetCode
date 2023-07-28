class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        
        int[] x = new int[points.length];
        for(int i = 0; i < points.length; i++){
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int max = 0;
        for(int i = 0; i < x.length-1; i++){
            max = Math.max(max, x[i+1] - x[i]);
        }
        return max;
    }
}