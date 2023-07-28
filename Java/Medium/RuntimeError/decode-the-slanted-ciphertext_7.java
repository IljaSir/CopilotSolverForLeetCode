class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int len = encodedText.length();
        int cols = len / rows;
        if (len % rows != 0) cols++;
        char[][] mat = new char[rows][cols];
        int r = 0, c = 0;
        for (int i = 0; i < len; i++) {
            mat[r][c] = encodedText.charAt(i);
            if (r == 0) {
                c++;
                r++;
            } else {
                r--;
            }
        }
        char[] ans = new char[len];
        int idx = 0;
        r = 0;
        c = 0;
        for (int i = 0; i < len; i++) {
            ans[idx++] = mat[r][c];
            if (r == 0) {
                c++;
                r++;
            } else {
                r--;
            }
        }
        return new String(ans);
    }
}