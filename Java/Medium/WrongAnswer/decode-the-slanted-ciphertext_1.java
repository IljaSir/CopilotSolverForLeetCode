class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int n = encodedText.length();
        int cols = (n + rows - 1) / rows;
        char[][] matrix = new char[rows][cols];
        int idx = 0;
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows && idx < n; i++) {
                if (j % 2 == 0) {
                    matrix[i][j] = encodedText.charAt(idx++);
                } else {
                    matrix[rows - i - 1][j] = encodedText.charAt(idx++);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != ' ') {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }
}