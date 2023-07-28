class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] res = new int[s.length()];
        int[] d = new int[] {0, 1, 0, -1, 0};
        int x = startPos[0], y = startPos[1];
        int dir = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            } else {
                int nx = x + d[dir], ny = y + d[dir + 1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    x = nx;
                    y = ny;
                }
            }
            grid[x][y] = i + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                dir = (dir + 1) % 4;
            } else if (c == 'R') {
                dir = (dir + 3) % 4;
            } else {
                int nx = x + d[dir + 2], ny = y + d[dir + 3];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    x = nx;
                    y = ny;
                }
            }
            res[i] = grid[x][y] - i - 1;
        }
        return res;
    }
}