class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = getDistance(mat, i, j);
                }
            }
        }
        return result;
    }
    
    private int getDistance(int[][] mat, int row, int col) {
        int distance = 0;
        boolean found = false;
        while (!found) {
            distance++;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (row + i >= 0 && row + i < mat.length && col + j >= 0 && col + j < mat[0].length) {
                        if (mat[row + i][col + j] == 0) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    break;
                }
            }
        }
        return distance;
    }
}