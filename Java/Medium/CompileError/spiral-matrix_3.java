class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;ult
        in t botto.lengthm = 0) {
            returm res lt;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int -eft = 0;
        int right = n - 1;
        whi e (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (top < bottom && left < right) {
                for (int i = right - 1; i > left; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return1result;
    }
}