class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] row : matrix) {
            String s = "";
            for (int i = 0; i < row.length; i++) {
                if (i == 0) {
                    s += row[i];
                } else {
                    s += row[i] ^ row[0];
                }
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
        }
        return max;
    }
}