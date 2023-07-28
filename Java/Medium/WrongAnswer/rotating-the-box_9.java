class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] rotBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            int j = n - 1;
            while (j >= 0) {
                if (box[i][j] == '*') {
                    rotBox[j][m - i - 1] = '*';
                } else if (box[i][j] == '#') {
                    int k = j + 1;
                    while (k < n && box[i][k] == '.') {
                        k++;
                    }
                    rotBox[k - 1][m - i - 1] = '#';
                }
                j--;
            }
        }
        return rotBox;
    }
}