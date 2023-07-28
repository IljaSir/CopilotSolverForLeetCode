class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        Map<Double, Integer> map = new HashMap<>();
        long res = 0;
        for (int[] r : rectangles) {
            double ratio = (double) r[0] / r[1];
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }
        for (double key : map.keySet()) {
            int count = map.get(key);
            res += (long) count * (count - 1) / 2;
        }
        return res;
    }
}