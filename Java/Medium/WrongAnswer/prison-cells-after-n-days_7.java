class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] next = new int[8];
        int[] temp = new int[8];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 7; j++) {
                temp[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            }
            next = temp;
            temp = cells;
            cells = next;
        }
        return cells;
    }
}