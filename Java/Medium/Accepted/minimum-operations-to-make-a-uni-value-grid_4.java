class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[n * m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[index++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int target = arr[(n * m) / 2];
        int ans = 0;
        for (int i = 0; i < n * m; i++) {
            int diff = Math.abs(arr[i] - target);
            if (diff % x != 0) {
                return -1;
            }
            ans += diff / x;
        }
        return ans;
    }
}