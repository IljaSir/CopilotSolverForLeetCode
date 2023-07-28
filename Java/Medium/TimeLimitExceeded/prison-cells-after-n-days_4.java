class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] res = new int[cells.length];
        for (int i = 0; i < cells.length; i++) {
            res[i] = cells[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (j == 0 || j == cells.length - 1) {
                    res[j] = 0;
                } else {
                    if (cells[j - 1] == cells[j + 1]) {
                        res[j] = 1;
                    } else {
                        res[j] = 0;
                    }
                }
            }
            cells = res.clone();
        }
        return res;
    }
}