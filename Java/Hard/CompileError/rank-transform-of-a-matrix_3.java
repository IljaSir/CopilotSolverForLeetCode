class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
            }
        }
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (!map.containsKey(val)) {
                    map.put(val, new ArrayList<>());
                }
                map.get(val).add(new int[]{i, j});
            }
        }
        int[] rank = new int[m + n];
        for (int val : map.keySet()) {
            List<int[]> list = map.get(val);
            int[] parent = new int[m + n];
            for (int i = 0; i < m + n; i++) {
                parent[i] = i;
            }
            for (int[] pair : list) {
                int x = pair[0];
                int y = pair[1];
                int px = find(parent, x);
                int py = find(parent, y + m);
                if (px != py) {
                    parent[px] = py;
                }
            }
            Map<Integer, Integer> maxRank = new HashMap<>();
            for (int[] pair : list) {
                int x = pair[0];
                int y = pair[1];
                int px = find(parent, x);
                int py = find(parent, y + m);
                int p = px;
                if (px != py) {
                    p = Math.min(px, py);
                }
                int r = Math.max(rank[x], rank[y + m]) + 1;
                maxRank.put(p, Math.max(maxRank.getOrDefault(p, 0), r));
            }
            for (int[] pair : list) {
                int x = pair[0];
                int y = pair[1];
                int px = find(parent, x);
                int py = find(parent, y + m);
                int p = px;
                if (px != py) {
                    p = Math.min(px, py);
                }
                res[x][y] =
    }
}