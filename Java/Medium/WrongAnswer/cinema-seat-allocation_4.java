class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int result = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = map.getOrDefault(i, new HashSet<>());
            boolean[] seats = new boolean[11];
            for (int j = 1; j <= 10; j++) {
                seats[j] = set.contains(j);
            }
            result += 2 - (seats[2] || seats[3] || seats[4] || seats[5] ? 1 : 0) - (seats[6] || seats[7] || seats[8] || seats[9] ? 1 : 0);
        }
        return result;
    }
}