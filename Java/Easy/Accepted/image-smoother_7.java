class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int[][] result = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int count = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < img.length && l >= 0 && l < img[i].length) {
                            result[i][j] += img[k][l];
                            count++;
                        }
                    }
                }
                result[i][j] = result[i][j] / count;
            }
        }
        return result;
    }
}