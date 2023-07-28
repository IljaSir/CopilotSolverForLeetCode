class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] <= mid){
                        count++;
                    }
                }
            }
            if(count < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}