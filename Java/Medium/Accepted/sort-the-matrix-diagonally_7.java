class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i, k = 0; j < m && k < n; j++, k++) {
                list.add(mat[j][k]);
            }
            Collections.sort(list);
            for (int j = i, k = 0; j < m && k < n; j++, k++) {
                result[j][k] = list.get(k);
            }
        }
        for (int i = 1; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0, k = i; j < m && k < n; j++, k++) {
                list.add(mat[j][k]);
            }
            Collections.sort(list);
            for (int j = 0, k = i; j < m && k < n; j++, k++) {
                result[j][k] = list.get(j);
            }
        }
        return result;
    }
}