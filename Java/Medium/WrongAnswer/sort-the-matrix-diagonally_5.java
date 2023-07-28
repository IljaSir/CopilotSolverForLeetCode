class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(mat[i]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i;
                int l = j;
                List<Integer> temp = new ArrayList<>();
                while (k < m && l < n) {
                    temp.add(mat[k++][l++]);
                }
                Collections.sort(temp);
                k = i;
                l = j;
                for (int x : temp) {
                    mat[k++][l++] = x;
                }
            }
        }
        return mat;
    }
}