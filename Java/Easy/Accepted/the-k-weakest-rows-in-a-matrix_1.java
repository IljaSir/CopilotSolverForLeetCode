class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] result = new int[k];
        int[] counts = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            counts[i] = count;
        }
        int[] countsCopy = counts.clone();
        Arrays.sort(countsCopy);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] == countsCopy[i]) {
                    result[i] = j;
                    counts[j] = -1;
                    break;
                }
            }
        }
        return result;
    }
}