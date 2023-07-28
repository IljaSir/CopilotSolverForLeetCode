class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int len = encodedText.length();
        if (rows == 1) {
            return encodedText;
        }
        int cols = len / rows + 1;
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (index < len) {
                    matrix[j][i] = encodedText.charAt(index++);
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