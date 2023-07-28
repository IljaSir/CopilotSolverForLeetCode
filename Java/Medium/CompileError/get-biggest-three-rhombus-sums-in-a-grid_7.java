class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[3];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        if (i == k && j == l) {
                            continue;
                        }
                        if (i == k || j == l) {
                            continue;
                        }
                        if (Math.abs(i - k) != Math.abs(j - l)) {
                            continue;
                        }
                        int sum = 0;
                        for (int x = i, y = j; x <= k && y <= l; x++, y++) {
                            sum += grid[x][y];
                        }
                        for (int x = k, y = l; x >= i && y >= j; x--, y--) {
                            sum += grid[x][y];
                        }
                        for (int x = i, y = l; x <= k && y >= j; x++, y--) {
                            sum += grid[x][y];
                        }
                        for (int x = k, y = j; x >= i && y <= l; x--, y++) {
                            sum += grid[x][y];
                        }
                        sum -= grid[i][j];
                        sum -= grid[k][l];
                        if (index == 0) {
                            res[index++] = sum;
                        } else if (index == 1) {
                            if (sum != res[0]) {
                                res[index++] = sum;
                            }
                        } else if (index == 2) {
                            if (sum != res[0] && sum != res[1]) {
                                res[index++] = sum;
                            }
                        } else {
                            if (sum != res[0] && sum != res[1] && sum != res[2]) {
                                if (sum > res[0]) {
                                    res[0] = sum;
                                } else if (sum > res[1]) {
                                    res[1] = sum;
                                } else if (sum > res[2]) {
                                    res[2] = sum;
                                }
                            }
                        }
                    }
                }
            }
    }
}