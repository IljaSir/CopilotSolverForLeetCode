class Solution {
    public int numberOfBoomerangs(int[][] points) {
        
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    int d = dist(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for (int v : map.values()) {
                ans += v * (v - 1);
            }
        }
        return ans;
    }
}