class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int result = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }
            map.get(row).add(col);
        }
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = map.getOrDefault(i, new HashSet<>());
            if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) {
                result++;
            }
            if (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) {
                result++;
            }
            if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) {
                result++;
            }
            if (set.contains(2) || set.contains(3) || set.contains(4) || set.contains(5) ||
                set.contains(6) || set.contains(7) || set.contains(8) || set.contains(9)) {
                continue;
            }
            result++;
        }
        return result;
    }
}