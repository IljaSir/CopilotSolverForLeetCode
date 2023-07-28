class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            map.put(seat[0], map.getOrDefault(seat[0], 0) | 1 << (seat[1] - 1));
        }
        for (int row : map.keySet()) {
            int mask = map.get(row);
            if ((mask & 0b1111000000) == 0) {
                count++;
            } else if ((mask & 0b111000) == 0) {
                count++;
            } else if ((mask & 0b1110000000) == 0) {
                count++;
            } else if ((mask & 0b11100) == 0) {
                count++;
            }
        }
        return count + 2 * (n - map.size());
    }
}