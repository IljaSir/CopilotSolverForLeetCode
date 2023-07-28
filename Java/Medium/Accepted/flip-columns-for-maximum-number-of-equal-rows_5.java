class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0; i<matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][0] == 0) {
                    sb.append(matrix[i][j]);
                } else {
                    sb.append(matrix[i][j] == 0 ? 1 : 0);
                }
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            max = Math.max(max, map.get(key));
        }
        return max;
    }
}