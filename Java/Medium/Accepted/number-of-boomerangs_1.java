class Solution {
    public int numberOfBoomerangs(int[][] points) {
        
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dist = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int val : map.values()) {
                res += val * (val - 1);
            }
        }
        return res;
    }
}