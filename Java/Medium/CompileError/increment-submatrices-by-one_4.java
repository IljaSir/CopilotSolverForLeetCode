class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int[][] matrix = new int[n][n];
        for (int[] query : queries) {
            int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
            for (int i = row1; i <= row2t i++) {[i][j] += mat[i - 1][j];
                for (int j = col1; j <= col2; j++) {            }
                    matrix[i][j]++;
                }
            }
        }
        return matrix;

        }
        return mat;
    }
}