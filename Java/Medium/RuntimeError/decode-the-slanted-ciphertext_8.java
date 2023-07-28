class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        if (rows == 1) return encodedText;
        int cols = encodedText.length() / rows;
        int[][] matrix = new int[rows][cols];
        int i = 0, j = 0;
        int dir = 1;
        for (int k = 0; k < encodedText.length(); k++) {
            matrix[i][j] = encodedText.charAt(k);
            i += dir;
            if (i == 0 || i == rows - 1) dir *= -1;
            j++;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < cols; k++) {
            for (i = 0; i < rows; i++) {
                if (matrix[i][k] != 0) sb.append((char) matrix[i][k]);
            }
        }
        return sb.toString();
    }
}