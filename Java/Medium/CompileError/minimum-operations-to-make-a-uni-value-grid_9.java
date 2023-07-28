class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] a = new int[m*n];
        int i = 0;
        for (int[] row : grid) {
            for (int v : row) {
                a[i++] = v;
            }
        }
        Arrays.sort(a);
        int mid = a[m*n/2];
        int ans = 0;
        for (int v : a) {
            if (Math.abs(v - mid) % x != 0) {
                return -1;
            }
            ans += Math.abs(v - mid) / x;
        }
        return ans;
    }
}
    }
}