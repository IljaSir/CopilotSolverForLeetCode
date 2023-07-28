class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        Map<Double, Integer> map = new HashMap<>();
        for (int[] r : rectangles) {
            double ratio = (double) r[0] / r[1];
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }
        long res = 0;
        for (double key : map.keySet()) {
            int val = map.get(key);
            res += val * (val - 1) / 2;
        }
        return res;
    }
}