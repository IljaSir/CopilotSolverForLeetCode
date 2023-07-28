class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            int j = n - 1;
            while (j >= 0) {
                if (box[i][j] == '*') {
                    j--;
                } else if (box[i][j] == '#') {
                    int k = j;
                    while (k + 1 < n && box[i][k + 1] == '.') {
                        box[i][k + 1] = '#';
                        box[i][k] = '.';
                        k++;
                    }
                    j--;
                } else {
                    j--;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = box[i][j];
            }
        }
        return result;
    }
}