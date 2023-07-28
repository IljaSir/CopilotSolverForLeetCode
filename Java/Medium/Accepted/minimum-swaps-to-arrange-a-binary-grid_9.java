class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] zeros = new int[n];
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=n-1; j>=0; j--){
                if(grid[i][j]==0){
                    count++;
                }else{
                    break;
                }
            }
            zeros[i] = count;
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(zeros[i]>=n-i-1){
                continue;
            }
            int j=i+1;
            while(j<n && zeros[j]<n-i-1){
                j++;
            }
            if(j==n){
                return -1;
            }
            while(j>i){
                int temp = zeros[j];
                zeros[j] = zeros[j-1];
                zeros[j-1] = temp;
                j--;
                ans++;
            }
        }
        return ans;
    }
}