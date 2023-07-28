class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] result = new int[k];
        int[][] temp = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            temp[i][0] = count;
            temp[i][1] = i;
        }
        Arrays.sort(temp, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < k; i++) {
            result[i] = temp[i][1];
        }
        return result;
    }
}