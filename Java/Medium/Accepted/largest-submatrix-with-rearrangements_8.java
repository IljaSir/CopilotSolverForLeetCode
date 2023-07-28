class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] count = new int[n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    count[j]++;
                } else {
                    count[j] = 0;
                }
            }
            max = Math.max(max, largestSubmatrixHelper(count));
        }
        return max;
    }
    
    public int largestSubmatrixHelper(int[] count) {
        int n = count.length;
        int[] sortedCount = Arrays.copyOf(count, n);
        Arrays.sort(sortedCount);
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, sortedCount[i] * (n - i));
        }
        return max;
    }
}