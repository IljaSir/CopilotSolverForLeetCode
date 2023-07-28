class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, Integer> reserved = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            reserved.put(row, reserved.getOrDefault(row, 0) | 1 << (col - 1));
        }

        int ans = 0;
        for (int row : reserved.keySet()) {
            int seats = reserved.get(row);
            if ((seats & 0b1111000000) == 0) {
                ans += 2;
            } else if ((seats & 0b0000111100) == 0) {
                ans += 2;
            } else if ((seats & 0b0000000011) == 0) {
                ans += 2;
            } else if ((seats & 0b0000001110) == 0) {
                ans += 2;
            } else if ((seats & 0b0000110000) == 0) {
                ans += 2;
            } else if ((seats & 0b1110000000) == 0) {
                ans += 2;
            } else if ((seats & 0b1100000000) == 0) {
                ans += 1;
            } else if ((seats & 0b0000000011) == 0) {
                ans += 1;
            } else if ((seats & 0b0000111100) == 0) {
                ans += 1;
            } else if ((seats & 0b0011110000) == 0) {
                ans += 1;
            } else if ((seats & 0b1100000000) == 0) {
                ans += 1;
            }
        }

        return ans + 2 * (n - reserved.size());
    }
}