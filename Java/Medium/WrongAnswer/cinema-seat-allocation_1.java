class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }
            map.get(row).add(col);
        }
        int result = n * 2;
        for (Integer row : map.keySet()) {
            Set<Integer> set = map.get(row);
            if (set.contains(2) || set.contains(3) || set.contains(4) || set.contains(5)) {
                result--;
            }
            if (set.contains(6) || set.contains(7) || set.contains(8) || set.contains(9)) {
                result--;
            }
            if (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) {
                result++;
            }
        }
        return result;
    }
}