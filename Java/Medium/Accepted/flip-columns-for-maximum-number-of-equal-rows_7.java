class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            String key = "";
            for (int i = 0; i < n; i++) {
                key += row[i] ^ row[0];
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        for (int val : map.values()) {
            ans = Math.max(ans, val);
        }
        return ans;
    }
}