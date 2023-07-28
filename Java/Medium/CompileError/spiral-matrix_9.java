class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = m - 1;
        int direction = 0;
        while (result.size() < m * n) {
            result.add(matrix[i][j]);
            switch (direction) {
                case 0:
                    if (j < right) {
                        j++;
                    } else {
                        direction = 1;
                        i++;
                        top++;
                    }
                    break;
                case 1:
                    if (i < bottom) {
                        i++;
                    } else {
                        direction = 2;
                        j--;
                        right--;
                    }
                    break;
                case 2:
                    if (j > left) {
                        j--;
                    } else {
                        direction = 3;
                        i--;
                        bottom--;
                    }
                    break;
                case 3:
                    if (i > top) {
                        i--;
                    } else {
                        direction = 0;
                        j++;
                        left++;
                    }
            } (int i = right - 1; i > left; i--) {
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
        return result;
    }
}