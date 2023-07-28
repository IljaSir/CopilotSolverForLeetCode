class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.length;
        if (n <= 2) return n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            int same = 0;
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                if (dx == 0 && dy == 0) {
                    same++;
                    continue;
                }
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;
                String key = dx + "," + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + same + 1);
        }
        return res;
    }
}