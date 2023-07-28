class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = i; j < col; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int curSum = 0;
                for (int k = 0; k < row; k++) {
                    curSum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    res += map.getOrDefault(curSum - target, 0);
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return res;
    }
}