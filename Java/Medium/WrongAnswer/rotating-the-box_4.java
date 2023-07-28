class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            int j = n - 1;
            while (j >= 0 && box[i][j] == '.') {
                j--;
            }
            int k = j - 1;
            while (k >= 0) {
                if (box[i][k] == '*') {
                    j = k - 1;
                } else if (box[i][k] == '#') {
                    box[i][j] = '#';
                    box[i][k] = '.';
                    j--;
                }
                k--;
            }
        }
        for (int j = 0; j < n; j++) {
            int i = m - 1;
            while (i >= 0 && box[i][j] == '.') {
                i--;
            }
            int k = i - 1;
            while (k >= 0) {
                if (box[k][j] == '*') {
                    i = k - 1;
                } else if (box[k][j] == '#') {
                    box[i][j] = '#';
                    box[k][j] = '.';
                    i--;
                }
                k--;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = box[i][j];
            }
        }
        return res;
    }
}