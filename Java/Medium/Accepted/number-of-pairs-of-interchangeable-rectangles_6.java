class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        Map<Double, Long> ratios = new HashMap<>();
        for (int[] r : rectangles) {
            double ratio = (double)r[0] / r[1];
            ratios.put(ratio, ratios.getOrDefault(ratio, 0L) + 1);
        }
        long total = 0;
        for (long count : ratios.values()) {
            total += count * (count - 1) / 2;
        }
        return total;
    }
}