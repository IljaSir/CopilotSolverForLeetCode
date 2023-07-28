class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[][] matrix = new int[k][k];
        int n = rowConditions.length;
        int m = colConditions.length;
        for (int i = 0; i < n; i++) {
            int above = rowConditions[i][0];
            int below = rowConditions[i][1];
            if (above == below) {
                return new int[0][0];
            }
            if (above > below) {
                matrix[above - 1][below - 1] = below;
                matrix[below - 1][above - 1] = above;
            } else {
                matrix[below - 1][above - 1] = above;
                matrix[above - 1][below - 1] = below;
            }
        }
        for (int i = 0; i < m; i++) {
            int left = colConditions[i][0];
            int right = colConditions[i][1];
            if (left == right) {
                return new int[0][0];
            }
            if (left > right) {
                matrix[right - 1][left - 1] = left;
                matrix[left - 1][right - 1] = right;
            } else {
                matrix[left - 1][right - 1] = right;
                matrix[right - 1][left - 1] = left;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (matrix[i][j] == 0) {
                    for (int l = 1; l <= k; l++) {
                        if (!set.contains(l)) {
                            matrix[i][j] = l;
                            set.add(l);
                            break;
                        }
                    }
                }
            }
        }
        return matrix;
    }
}