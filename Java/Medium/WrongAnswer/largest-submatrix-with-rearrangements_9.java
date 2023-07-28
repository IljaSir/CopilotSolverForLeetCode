class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] count = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    count[j]++;
                }
                else{
                    count[j] = 0;
                }
            }
            Arrays.sort(count);
            for(int j = n - 1; j >= 0; j--){
                count[j] = (n - j) * count[j];
            }
            Arrays.sort(count);
        }
        return count[n - 1];
    }
}