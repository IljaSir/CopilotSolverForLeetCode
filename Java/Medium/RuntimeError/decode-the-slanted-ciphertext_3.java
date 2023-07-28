class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int cols = encodedText.length() / rows;
        char[][] matrix = new char[rows][cols];
        int row = 0, col = 0;
        boolean down = true;
        for (char c : encodedText.toCharArray()) {
            matrix[row][col] = c;
            if (row == rows - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }
            if (down) {
                row++;
            } else {
                row--;
                col++;
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