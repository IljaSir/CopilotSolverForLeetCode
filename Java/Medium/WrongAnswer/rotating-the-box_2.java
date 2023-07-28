class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                res[i][m - j - 1] = box[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] == '#') {
                    int k = j;
                    while (k < m - 1 && res[i][k + 1] == '.') {
                        k++;
                    }
                    if (k != j) {
                        res[i][j] = '.';
                        res[i][k] = '#';
                    }
                }
            }
        }
        return res;
    }
}