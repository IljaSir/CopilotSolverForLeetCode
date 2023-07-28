class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col == 1 || col == 10) {
                continue;
            }
            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 2)));
        }
        int res = 2 * n;
        for (int row : map.keySet()) {
            int seat = map.get(row);
            if ((seat & (1 << 0)) == 0 && (seat & (1 << 1)) == 0 && (seat & (1 << 2)) == 0 && (seat & (1 << 3)) == 0) {
                res--;
            } else if ((seat & (1 << 2)) == 0 && (seat & (1 << 3)) == 0 && (seat & (1 << 4)) == 0 && (seat & (1 << 5)) == 0) {
                res--;
            } else if ((seat & (1 << 4)) == 0 && (seat & (1 << 5)) == 0 && (seat & (1 << 6)) == 0 && (seat & (1 << 7)) == 0) {
                res--;
            } else if ((seat & (1 << 6)) == 0 && (seat & (1 << 7)) == 0 && (seat & (1 << 8)) == 0 && (seat & (1 << 9)) == 0) {
                res--;
            }
        }
        return res;
    }
}