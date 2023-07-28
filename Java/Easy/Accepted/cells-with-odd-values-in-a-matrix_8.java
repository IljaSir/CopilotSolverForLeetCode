class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        
        for(int[] index : indices){
            rows[index[0]]++;
            cols[index[1]]++;
        }
        
        int odd = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = rows[i] + cols[j];
                if(sum % 2 == 1){
                    odd++;
                }
            }
        }
        
        return odd;
    }
}