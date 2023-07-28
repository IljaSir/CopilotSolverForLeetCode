class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m/2;j++){
                int t = image[i][j];
                image[i][j] = image[i][m-j-1];
                image[i][m-j-1] = t;
            }
            for(int j=0;j<m;j++){
                image[i][j] = image[i][j]^1;
            }
        }
        return image;
    }
}