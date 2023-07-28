class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m*n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[k++] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        int median = nums[(m*n)/2];
        int res = 0;
        for (int i = 0; i < m*n; i++) {
            if ((nums[i]-median)%x != 0) {
                return -1;
            }
            res += Math.abs(nums[i]-median)/x;
        }
        return res;
    }
}