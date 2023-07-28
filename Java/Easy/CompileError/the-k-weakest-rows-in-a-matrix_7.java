class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] res = new int[k];
        int[] count = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    break;
                }
                count[i]++;
            }
        }
        int[] indexes = new int[mat.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                if (count[i1] == count[i2]) {
                    return i1 - i2;
                }
                return count[i1] - count[i2];
            }
        });
        for (int i = 0; i < k; i++) {
            res[i] = indexes[i];
        }
        return res;
    }
}