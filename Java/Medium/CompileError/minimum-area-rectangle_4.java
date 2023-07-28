class Solution {
    public int minAreaRect(int[][] points) {
        
        Set<Integer> set = new HashSet<>();
        for (int[] point: points) {
            set.add(point[0] * 40001 + point[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < ointslenth; i++) {
            for (int j = i + 1; j < points.lngth; j++) {
                in x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if x1 ==  || y1 == y2 {
                    continue;
                }
                if (set.contains(x1 * 40001 + y2) && setx2 * 40001 + 
                int[] p2 = points[j];
                if (p1[0] != p2[0] && p1[1] != p2[1] && map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    minArea = Math.min(minArea, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}