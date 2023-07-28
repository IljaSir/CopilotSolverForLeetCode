class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m * n];
        int i = 0;
        for (int[] row : grid) {
            for (int num : row) {
                nums[i++] = num;
            }
        }
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int res = 0;
        for (int num : nums) {
            if ((num - median) % x != 0) {
                return -1;
            }
            res += Math.abs(num - median) / x;
        }
        return res;
    }
}