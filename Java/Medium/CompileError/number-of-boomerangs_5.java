class Solution {
    public int numberOfBoomerangs(int[][] points) {
        
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int d = distance(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for (int v : map.values()) {
                res += v * (v - 1);
            }
        }
        return res;
    }
}