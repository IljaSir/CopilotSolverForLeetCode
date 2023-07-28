class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int n = img1.length;
        int[][] sum = new int[2*n+1][2*n+1];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(img1[i][j]==1) {
                    for(int k=0;k<n;k++) {
                        for(int l=0;l<n;l++) {
                            if(img2[k][l]==1) {
                                sum[i-k+n][j-l+n]++;
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i=0;i<2*n+1;i++) {
            for(int j=0;j<2*n+1;j++) {
                max = Math.max(max, sum[i][j]);
            }
        }
        return max;
    }
}