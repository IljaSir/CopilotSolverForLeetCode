class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int n = encodedText.length();
        int cols = n / rows;
        char[][] matrix = new char[rows][cols];
        int k = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (k < n) {
                    matrix[j][i] = encodedText.charAt(k);
                    k++;
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
    }
}