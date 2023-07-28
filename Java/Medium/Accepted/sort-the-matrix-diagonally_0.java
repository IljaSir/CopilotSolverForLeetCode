class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(i - j, new ArrayList<>());
                map.get(i - j).add(mat[i][j]);
            }
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = map.get(i - j).remove(0);
            }
        }
        return mat;
    }
}