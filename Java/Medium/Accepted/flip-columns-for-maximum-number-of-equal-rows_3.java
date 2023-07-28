class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            int n = row.length;
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb1.append(row[i]);
                sb2.append(1 - row[i]);
            }
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            map.put(s1, map.getOrDefault(s1, 0) + 1);
            map.put(s2, map.getOrDefault(s2, 0) + 1);
        }
        int max = 0;
        for (String key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }
}