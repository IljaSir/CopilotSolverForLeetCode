class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                ans[i][m - 1 - j] = box[j][i];
            }
        }
        for (int i = 0; i < m; i++) {
            int j = n - 1;
            while (j >= 0 && ans[j][i] != '#') {
                j--;
            }
            int k = j - 1;
            while (k >= 0) {
                if (ans[k][i] == '#') {
                    ans[j][i] = '#';
                    ans[k][i] = '.';
                    j--;
                }
                k--;
            }
        }
        return ans;
    }
}