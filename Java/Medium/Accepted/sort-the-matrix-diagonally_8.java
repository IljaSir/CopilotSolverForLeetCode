class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int row = mat.length;
        int col = mat[0].length;
        for(int i=0; i<row; i++){
            int[] temp = new int[Math.min(row-i, col)];
            for(int j=0; j<temp.length; j++){
                temp[j] = mat[i+j][j];
            }
            Arrays.sort(temp);
            for(int j=0; j<temp.length; j++){
                mat[i+j][j] = temp[j];
            }
        }
        for(int i=1; i<col; i++){
            int[] temp = new int[Math.min(row, col-i)];
            for(int j=0; j<temp.length; j++){
                temp[j] = mat[j][i+j];
            }
            Arrays.sort(temp);
            for(int j=0; j<temp.length; j++){
                mat[j][i+j] = temp[j];
            }
        }
        return mat;
    }
}