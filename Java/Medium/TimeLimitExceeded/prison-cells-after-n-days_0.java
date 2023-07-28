class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] temp = new int[8];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 7; j++) {
                if (cells[j - 1] == cells[j + 1]) {
                    temp[j] = 1;
                } else {
                    temp[j] = 0;
                }
            }
            cells = temp.clone();
        }
        return cells;
    }
}