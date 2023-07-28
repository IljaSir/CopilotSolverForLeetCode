class Solution {
    public int numberOfBoomerangs(int[][] points) {
        
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] p2 = points[j];
                int dist = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int key : map.keySet()) {
                int count = map.get(key);
                ans += count * (count - 1);
            }
        }
        return ans;
    }
}