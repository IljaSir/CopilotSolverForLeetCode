class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (magic(grid[i][j], grid[i][j + 1], grid[i][j + 2],
                          grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                          grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2])) {
                    res++;
                }
            }
        }
        return res;
    }
    
    private boolean magic(int... vals) {
        Set<Integer> set = new HashSet<>();
        for (int v : vals) {
            set.add(v);
        }
        if (set.size() != 9) {
            return false;
        }
        for (int i = 1; i <= 9; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }
}