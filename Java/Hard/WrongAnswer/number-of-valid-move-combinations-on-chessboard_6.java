class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int n = pieces.length;
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1};
        int ans = 0;
        int[] row = new int[8];
        int[] col = new int[8];
        int[] diag = new int[15];
        int[] anti = new int[15];
        for (int i = 0; i < n; i++) {
            int x = positions[i][0] - 1;
            int y = positions[i][1] - 1;
            if (pieces[i].equals("rook")) {
                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    while (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                        ans++;
                        nx += d[0];
                        ny += d[1];
                    }
                }
            } else if (pieces[i].equals("bishop")) {
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    while (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                        ans++;
                        nx += dx[j];
                        ny += dy[j];
                    }
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    int nx = x + dir[j][0];
                    int ny = y + dir[j][1];
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                        ans++;
                    }
                }
            }
            ans -= row[x] + col[y] + diag[x + y] + anti[x - y + 7];
            row[x]++;
            col[y]++;
            diag[x + y]++;
            anti[x - y + 7]++;
        }
        return ans;
    }
}