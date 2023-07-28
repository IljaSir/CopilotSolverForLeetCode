class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] tmp = new int[m * n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[index++] = grid[i][j];
            }
        }
        k %= (m * n);
        if (k != 0) {
            reverse(tmp, 0, m * n - 1);
            reverse(tmp, 0, k - 1);
            reverse(tmp, k, m * n - 1);
        }
        index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(tmp[index++]);
            }
            ans.add(row);
        }
        return ans;
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}