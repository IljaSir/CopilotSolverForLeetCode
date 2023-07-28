class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        for (int i = m - 1; i >= 0; i--) {
            int x = i;
            int y = 0;
            List<Integer> list = new ArrayList<>();
            while (x < m && y < n) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x = i;
            y = 0;
            int idx = 0;
            while (x < m && y < n) {
                mat[x][y] = list.get(idx);
                x++;
                y++;
                idx++;
            }
        }
        for (int i = 1; i < n; i++) {
            int x = 0;
            int y = i;
            List<Integer> list = new ArrayList<>();
            while (x < m && y < n) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x = 0;
            y = i;
            int idx = 0;
            while (x < m && y < n) {
                mat[x][y] = list.get(idx);
                x++;
                y++;
                idx++;
            }
        }
        return mat;
    }
}