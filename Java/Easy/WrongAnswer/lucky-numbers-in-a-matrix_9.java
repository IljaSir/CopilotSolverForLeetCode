class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        int min = 0;
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            min = matrix[i][0];
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
            for(int k = 0; k < matrix.length; k++){
                if(matrix[k][i] > max){
                    max = matrix[k][i];
                }
            }
            if(min == max){
                list.add(min);
            }
        }
        return list;
    }
}