class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            int last = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    res[j][m - i - 1] = '#';
                    box[i][j] = '.';
                } else if (box[i][j] == '*') {
                    last = j - 1;
                } else {
                    if (last > j) {
                        res[last][m - i - 1] = '#';
                        box[i][j] = '.';
                    }
                }
            }
        }
        return res;
    }
}