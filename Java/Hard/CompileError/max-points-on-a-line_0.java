class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.length;
        if (n < 3) {
            return n;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            Map<String, Integer> map = new HashMap<>();
            int same = 1;
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    same++;
                    continue;
                }
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                int g = gcd(dx, dy);
                String slope = (dx / g) + "/" + (dy / g);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
            }
            ans = Math.max(ans, same);
            for (int count : map.values()) {
                ans = Math.max(ans, count + same);
            }
        }
        return ans;
    }
}