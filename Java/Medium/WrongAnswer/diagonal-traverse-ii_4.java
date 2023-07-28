class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int n = nums.size();
        int m = 0;
        for (List<Integer> num : nums) {
            m = Math.max(m, num.size());
        }
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                matrix[i][j] = nums.get(i).get(j);
            }
        }
        int[] ans = new int[n * m];
        int index = 0;
        for (int i = 0; i < n + m - 1; i++) {
            int r = Math.min(i, n - 1);
            int c = i - r;
            while (r >= 0 && c < m) {
                ans[index++] = matrix[r][c];
                r--;
                c++;
            }
        }
        return ans;
    }
}