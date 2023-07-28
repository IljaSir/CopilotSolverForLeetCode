class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = box[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            int p = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if (res[i][j] == '.') {
                    continue;
                }
                if (res[i][j] == '*') {
                    p = j - 1;
                    continue;
                }
                res[i][j] = '.';
                res[i][p] = '#';
                p--;
            }
        }
        return res;
    }
}