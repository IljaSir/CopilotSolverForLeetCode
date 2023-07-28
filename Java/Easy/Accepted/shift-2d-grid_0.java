class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = grid[i][j];
            }
        }
        k %= m * n;
        int[] arr2 = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            arr2[(i + k) % (m * n)] = arr[i];
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(arr2[i * n + j]);
            }
            res.add(list);
        }
        return res;
    }
}