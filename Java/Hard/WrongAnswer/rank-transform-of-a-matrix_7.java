class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int[] row = new int[m];
        int[] col = new int[n];
        for (int key : map.keySet()) {
            List<int[]> list = map.get(key);
            int[] parent = new int[m + n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            int[] size = new int[m + n];
            Arrays.fill(size, 1);
            for (int[] pos : list) {
                int i = pos[0];
                int j = pos[1];
                int p1 = find(parent, i);
                int p2 = find(parent, j + m);
                if (p1 != p2) {
                    parent[p1] = p2;
                    size[p2] += size[p1];
                }
            }
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int[] pos : list) {
                int i = pos[0];
                int j = pos[1];
                int p = find(parent, i);
                if (!map2.containsKey(p)) {
                    map2.put(p, Math.max(row[i], col[j]) + 1);
                }
                result[i][j] = map2.get(p);
            }
            for (int[] pos : list) {
                int i = pos[0];
                int j = pos[1];
                int p = find(parent, i);
                row[i] = col[j] = result[i][j];
            }
        }
        return result;
    }
    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}