class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] ^ matrix[i][0]);
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}