class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[] a = new int[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i*m+j] = grid[i][j];
            }
        }
        Arrays.sort(a);
        int mid = a[n*m/2];
        int sum = 0;
        for (int i = 0; i < n*m; i++) {
            int diff = Math.abs(a[i]-mid);
            if (diff%x != 0) {
                return -1;
            }
            sum += diff/x;
        }
        return sum;
    }
}