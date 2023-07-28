class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] row : matrix) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i : row) {
                sb1.append(i);
                sb2.append(1 - i);
            }
            String key1 = sb1.toString();
            String key2 = sb2.toString();
            map.put(key1, map.getOrDefault(key1, 0) + 1);
            map.put(key2, map.getOrDefault(key2, 0) + 1);
            max = Math.max(max, Math.max(map.get(key1), map.get(key2)));
        }
        return max;
    }
}