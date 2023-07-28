class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        int n = encodedText.length();
        int cols = n / rows;
        int[][] matrix = new int[rows][cols];
        int k = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[j][i] = k++;
            }
        }
        int[] count = new int[rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                count[j]++;
            }
        }
        int[] pos = new int[rows];
        int[] pos2 = new int[rows];
        for (int i = 0; i < rows; i++) {
            pos[i] = count[i] - 1;
            pos2[i] = count[i] - 1;
        }
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            int p = -1;
            for (int j = 0; j < rows; j++) {
                if (pos[j] >= 0) {
                    p = j;
                    break;
                }
            }
            res[matrix[p][pos[p]]] = encodedText.charAt(i);
            pos[p]--;
        }
        return new String(res);
    }
}