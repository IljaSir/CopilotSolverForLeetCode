class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int n = encodedText.length();
        int cols = n/rows;
        char[][] mat = new char[rows][cols];
        int k = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (k < n) {
                    mat[j][i] = encodedText.charAt(k++);
                } else {
                    mat[j][i] = ' ';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != ' ') {
                    sb.append(mat[i][j]);
                }
            }
        }
        return sb.toString();
    }
}