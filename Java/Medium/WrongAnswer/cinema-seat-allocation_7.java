class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] r : reservedSeats) {
            int row = r[0], col = r[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 1)));
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            if ((val & 0b1111000000) == 0) res += 2;
            else if ((val & 0b111100) == 0 || (val & 0b11110000) == 0) res++;
        }
        return res + (n - map.size()) * 2;
    }
}