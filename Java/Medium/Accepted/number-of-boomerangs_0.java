class Solution {
    public int numberOfBoomerangs(int[][] points) {
        
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int d = dx * dx + dy * dy;
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (int val : map.values()) {
                res += val * (val - 1);
            }
        }
        return res;
    }
}