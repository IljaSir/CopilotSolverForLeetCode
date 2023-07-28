class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        Map<String, Integer> map = new HashMap<>();
        long ans = 0;
        for (int[] r : rectangles) {
            int g = gcd(r[0], r[1]);
            String key = r[0] / g + "/" + r[1] / g;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int v : map.values()) {
            ans += (long) v * (v - 1) / 2;
        }
        return ans;
    }
}