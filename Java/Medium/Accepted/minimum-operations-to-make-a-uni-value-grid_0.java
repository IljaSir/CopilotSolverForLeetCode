class Solution {
    public int minOperations(int[][] grid, int x) {
        
        List<Integer> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int mid = list.get((m * n) / 2);
        int count = 0;
        for (int i = 0; i < m * n; i++) {
            int mod = Math.abs(list.get(i) - mid) % x;
            if (mod != 0) {
                return -1;
            }
            count += Math.abs(list.get(i) - mid) / x;
        }
        return count;
    }
}