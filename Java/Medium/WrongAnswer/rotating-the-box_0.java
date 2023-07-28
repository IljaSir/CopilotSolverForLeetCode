class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    res[j][m - 1 - i] = '*';
                } else if (box[i][j] == '#') {
                    int k = j + 1;
                    while (k < n && box[i][k] == '.') {
                        k++;
                    }
                    if (k < n && box[i][k] == '*') {
                        res[k - 1][m - 1 - i] = '#';
                    } else {
                        res[n - 1][m - 1 - i] = '#';
                    }
                } else {
                    res[j][m - 1 - i] = '.';
                }
            }
        }
        return res;
    }
}