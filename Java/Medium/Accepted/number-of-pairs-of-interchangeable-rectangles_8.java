class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        Map<Double, Long> map = new HashMap<>();
        long result = 0;
        for (int[] r : rectangles) {
            double ratio = (double) r[0] / r[1];
            long count = map.getOrDefault(ratio, 0L);
            result += count;
            map.put(ratio, count + 1);
        }
        return result;
    }
}