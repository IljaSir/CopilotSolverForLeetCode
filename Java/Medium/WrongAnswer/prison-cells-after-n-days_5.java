class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] res = new int[8];
        for (int i = 0; i < 8; i++) {
            res[i] = cells[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 7; j++) {
                if (cells[j - 1] == cells[j + 1]) {
                    res[j] = 1;
                } else {
                    res[j] = 0;
                }
            }
            for (int j = 0; j < 8; j++) {
                cells[j] = res[j];
            }
        }
        return res;
    }
}