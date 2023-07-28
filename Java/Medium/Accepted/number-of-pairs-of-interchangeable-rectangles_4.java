class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        Map<Double, Long> map = new HashMap<>();
        for (int[] r : rectangles) {
            double k = 1.0 * r[0] / r[1];
            map.put(k, map.getOrDefault(k, 0L) + 1);
        }
        long ans = 0;
        for (long v : map.values()) {
            ans += v * (v - 1) / 2;
        }
        return ans;
    }
}