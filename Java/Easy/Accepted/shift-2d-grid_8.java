class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }
        k = k % (m * n);
        int[] resArr = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            resArr[(i + k) % (m * n)] = arr[i];
        }
        idx = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(resArr[idx++]);
            }
            res.add(list);
        }
        return res;
    }
}