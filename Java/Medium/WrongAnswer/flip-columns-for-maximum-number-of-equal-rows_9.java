class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        int max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] counts = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(matrix[i][j]);
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
        }
        return max;
    }
}