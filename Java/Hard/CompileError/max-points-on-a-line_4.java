class Solution {
    public int maxPoints(int[][] points) {
        
        if (points.length == 0) {
            return 0;
        }
        f (poi
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            Map<String, Integer> map = new HashMap<>();
            int same = 0;
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    same++;
                    continue;
                }
                int x = p1[0] - p2[0];
                int y = p1[1] - p2[1];
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = x + "," + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            ans = Math.max(ans, same);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                ans = Math.max(ans, entry.getValue() + same + 1);
            }
        }
        return ans;
    }
}