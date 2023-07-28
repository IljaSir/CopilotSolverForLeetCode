class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] next = new int[cells.length];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                if (cells[j - 1] == cells[j + 1]) {
                    next[j] = 1;
                } else {
                    next[j] = 0;
                }
            }
            cells = next;
            next = new int[cells.length];
        }
        return cells;
    }
}