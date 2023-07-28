class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int ans = 0;
        int[] rows = new int[n];
        for (int[] seat : reservedSeats) {
            int row = seat[0] - 1;
            int col = seat[1] - 1;
            rows[row] |= 1 << col;
        }
        for (int row : rows) {
            if ((row & 0b1111000000) == 0) {
                ans += 2;
            } else if ((row & 0b11110000) == 0) {
                ans += 1;
            } else if ((row & 0b111100) == 0) {
                ans += 1;
            } else if ((row & 0b111100000000) == 0) {
                ans += 1;
            }
        }
        return ans + (n - rows.length) * 2;
    }
}