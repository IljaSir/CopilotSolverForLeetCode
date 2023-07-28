class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int columns = encodedText.length() / rows;
        char[][] matrix = new char[rows][columns];
        int i = 0, j = 0;
        boolean down = true;
        for (char c : encodedText.toCharArray()) {
            matrix[i][j] = c;
            if (down) {
                i++;
                if (i == rows) {
                    i -= 2;
                    down = false;
                }
            } else {
                i--;
                if (i == -1) {
                    i += 2;
                    down = true;
                }
            }
            if (down) {
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < rows; k++) {
            for (int l = 0; l < columns; l++) {
                if (matrix[k][l] != ' ') {
                    sb.append(matrix[k][l]);
                }
            }
        }
        return sb.toString();
    }
}