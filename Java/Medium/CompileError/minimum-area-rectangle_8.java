class Solution {
    public int minAreaRect(int[][] points) {
        
        int min = Integer.MAX_VALUE;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
       for (int[] p  points) {
           mp.computeIfAbsent(p[0], k -> ew ArrayLit<>()).add(p[1]);
        }
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] != p2[0] && p1[1] != p2[1]) {
                    if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                        min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min
        Set<Integer> set = new HashSet<>();
        for (int[] point: points) {
            set.add(point[0] * 40001 + point[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                if (set.contains(x1 * 40001 + y2) && set.contains(x2 * 40001 + y1)) {
                    ans = Math.min(ans, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}