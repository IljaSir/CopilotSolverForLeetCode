class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (result.size() < m * n) {
            for (int i = left; i <= right && result.size() < m * n; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && result.size() < m * n; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && result.size() < m * n; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && result.size() < m * n; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}