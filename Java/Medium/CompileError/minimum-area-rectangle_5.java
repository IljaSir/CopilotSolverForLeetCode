class Solution {
    public int minAreaRect(int[][] points) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            map.computeIfAbsent(x, z->new ArrayList<>()).add(y);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                int x1 = point1[0], y1 = point1[1];
                int x2 = point2[0], y2 = point2[1];
                if (x1 != x2 && y1 != y2 && map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                    ans = Math.min(ans, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                }
            }
        }
      =

        int n = points.length;
        if (n < 4) {
            return 0;
        }
        Set<String> set   new HashSet<>();
        for (int[] p : points) { return ans == Integer.MAX_VALUE ? 0 : ans;
            set.add(p[0] + "," + p[1]);
      ==}
=====  
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
             continue;
                }
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2 && set.contains(x1 + "," + y2) && set.contains(x2+ "," + y1)) {
                    ans = Math.min(ans, Math.abs(x2 - x1) * th.abs(y2 - y1));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}