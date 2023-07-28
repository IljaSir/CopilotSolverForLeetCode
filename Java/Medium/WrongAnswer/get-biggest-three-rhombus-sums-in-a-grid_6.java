class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[3];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = grid[i][j];
                int l = 1;
                while (i - l >= 0 && j - l >= 0 && i + l < m && j + l < n) {
                    sum += grid[i - l][j] + grid[i + l][j] + grid[i][j - l] + grid[i][j + l];
                    if (count < 3) {
                        res[count++] = sum;
                        Arrays.sort(res);
                    } else {
                        if (sum > res[0]) {
                            res[0] = sum;
                            Arrays.sort(res);
                        }
                    }
                    l++;
                }
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = res[i];
        }
        return result;
    }
}