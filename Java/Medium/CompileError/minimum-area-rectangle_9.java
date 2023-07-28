class Solution {
    public int minAreaRect(int[][] points) {
        
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
            } 0 : min;
    }
}