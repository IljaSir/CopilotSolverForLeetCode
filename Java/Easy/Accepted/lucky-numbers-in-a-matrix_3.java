class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] min = new int[m];
        int[] max = new int[n];
        for(int i = 0; i < m; i++){
            min[i] = 0;
            for(int j = 1; j < n; j++){
                if(matrix[i][j] < matrix[i][min[i]])
                    min[i] = j;
            }
        }
        for(int i = 0; i < n; i++){
            max[i] = 0;
            for(int j = 1; j < m; j++){
                if(matrix[j][i] > matrix[max[i]][i])
                    max[i] = j;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(min[i] == j && max[j] == i)
                    result.add(matrix[i][j]);
            }
        }
        return result;
    }
}