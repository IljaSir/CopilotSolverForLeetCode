class Solution {
    public int minAreaRect(int[][] points) {
        
        int n = points.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            map.computeIfAbsent(x, z -> new HashSet<>()).add(y);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2 && map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                    min = Math.min(min, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}