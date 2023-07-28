class Solution {
    public int minAreaRect(int[][] points) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }
            map.get(x).add(y);
        }
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i];ap.get(x2).contains(y1)) {
                    ans = Mth.min(ans, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}