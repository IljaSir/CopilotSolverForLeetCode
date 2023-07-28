class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[n * m];
        int idx = 0;
        for (int[] row : grid) {
            for (int v : row) {
                arr[idx++] = v;
            }
        }
        Arrays.sort(arr);
        int mid = arr[(n * m) / 2];
        int ans = 0;
        for (int v : arr) {
            int diff = Math.abs(mid - v);
            if (diff % x != 0) {
                return -1;
            }
            ans += diff / x;
        }
        return ans;
    }
}