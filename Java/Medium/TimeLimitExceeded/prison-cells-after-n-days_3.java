class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] res = new int[cells.length];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                if (cells[j - 1] == cells[j + 1]) {
                    res[j] = 1;
                } else {
                    res[j] = 0;
                }
            }
            cells = res.clone();
        }
        return res;
    }
}