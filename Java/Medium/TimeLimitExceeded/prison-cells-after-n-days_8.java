class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        // n = n % 14;
        // if (n == 0) n = 14;
        int[] res = new int[8];
        while (n > 0) {
            for (int i = 0; i < 8; i++) {
                if (i == 0 || i == 7) {
                    res[i] = 0;
                } else {
                    res[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
                }
            }
            cells = res;
            res = new int[8];
            n--;
        }
        return cells;
    }
}