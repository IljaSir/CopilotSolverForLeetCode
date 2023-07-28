class Solution {
    public long gridGame(int[][] grid) {
        
        long[] left = new long[grid[0].length];
        long[] right = new long[grid[0].length];
        long sum = 0;
        for(int i=0;i<grid[0].length;i++){
            sum += grid[0][i];
            left[i] = sum;
        }
        sum = 0;
        for(int i=grid[0].length-1;i>=0;i--){
            sum += grid[1][i];
            right[i] = sum;
        }
        long min = Long.MAX_VALUE;
        for(int i=0;i<grid[0].length-1;i++){
            min = Math.min(min, Math.max(left[i], right[i+1]));
        }
        return min;
    }
}