class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] res = new int[s.length()];
        int[][] grid = new int[n][n];
        int row = startPos[0];
        int col = startPos[1];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R' && col < n - 1) {
                col++;
            }
            if (s.charAt(i) == 'L' && col > 0) {
                col--;
            }
            if (s.charAt(i) == 'U' && row > 0) {
                row--;
            }
            if (s.charAt(i) == 'D' && row < n - 1) {
                row++;
            }
            grid[row][col] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (grid[row][col] == 1) {
                count++;
            }
            res[i] = count;
            if (s.charAt(i) == 'R' && col > 0) {
                col--;
            }
            if (s.charAt(i) == 'L' && col < n - 1) {
                col++;
            }
            if (s.charAt(i) == 'U' && row < n - 1) {
                row++;
            }
            if (s.charAt(i) == 'D' && row > 0) {
                row--;
            }
        }
        return res;
    }
}