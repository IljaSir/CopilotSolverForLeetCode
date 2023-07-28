class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= Math.min(i, j) && k <= Math.min(m - i, n - j); k++) {
                    int s = sum[i + k][j + k] - sum[i + k][j - k - 1] - sum[i - k - 1][j + k] + sum[i - k - 1][j - k - 1];
                    set.add(s);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] ans = new int[Math.min(3, list.size())];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(list.size() - 1 - i);
        }
        return ans;
    }
}