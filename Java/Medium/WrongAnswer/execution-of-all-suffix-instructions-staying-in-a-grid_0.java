class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] res = new int[s.length()];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = startPos[0];
        int y = startPos[1];
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        memo[x][y] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                y--;
            } else if (s.charAt(i) == 'R') {
                y++;
            } else if (s.charAt(i) == 'U') {
                x--;
            } else {
                x++;
            }
            if (x >= 0 && x < n && y >= 0 && y < n) {
                memo[x][y] = i + 1;
            }
        }
        x = startPos[0];
        y = startPos[1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                y--;
            } else if (s.charAt(i) == 'R') {
                y++;
            } else if (s.charAt(i) == 'U') {
                x--;
            } else {
                x++;
            }
            res[i] = i + 1;
            if (x >= 0 && x < n && y >= 0 && y < n) {
                res[i] = Math.max(res[i], memo[x][y]);
            }
        }
        return res;
    }
}