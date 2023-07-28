class Solution {
    public int equalPairs(int[][] grid) {
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(i != j){
                    if(Arrays.equals(grid[i], grid[j])){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}