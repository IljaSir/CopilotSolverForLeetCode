class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for (int i = 0; i < m; i++) {
            int p = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    ans[p--][m - 1 - i] = '#';
                } else if (box[i][j] == '*') {
                    p = j - 1;
                }
            }
            while (p >= 0) {
                ans[p--][m - 1 - i] = '.';
            }
        }
        return ans;
    }
}