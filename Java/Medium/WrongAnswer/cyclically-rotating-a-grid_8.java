class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;
        while (l < r && t < b) {
            int size = (r - l + 1) * 2 + (b - t - 1) * 2;
            int[] nums = new int[size];
            int index = 0;
            for (int i = l; i <= r; i++) {
                nums[index++] = grid[t][i];
            }
            for (int i = t + 1; i <= b - 1; i++) {
                nums[index++] = grid[i][r];
            }
            for (int i = r; i >= l; i--) {
                nums[index++] = grid[b][i];
            }
            for (int i = b - 1; i >= t + 1; i--) {
                nums[index++] = grid[i][l];
            }
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[(i + k) % size] = nums[i];
            }
            index = 0;
            for (int i = l; i <= r; i++) {
                result[t][i] = temp[index++];
            }
            for (int i = t + 1; i <= b - 1; i++) {
                result[i][r] = temp[index++];
            }
            for (int i = r; i >= l; i--) {
                result[b][i] = temp[index++];
            }
            for (int i = b - 1; i >= t + 1; i--) {
                result[i][l] = temp[index++];
            }
            l++;
            r--;
            t++;
            b--;
        }
        return result;
    }
}