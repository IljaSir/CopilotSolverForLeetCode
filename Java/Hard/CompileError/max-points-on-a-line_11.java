class Solution {
    public int maxPoints(int[][] points) {
        
        if (points.length <= 2) {
            return points.length;
        }
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            int same = 0;
            int vertical = 1;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                if (point1[0] == point2[0] && point1[1] == point2[1]) {
                    same++;
                } else if (point1[0] == point2[0]) {
                    vertical++;
                } else {
                    int x = point2[0] - point1[0];
                    int y = point2[1] - point1[1];
                    int gcd = gcd(x, y);
                    x /= gcd;
                    y /= gcd;
                    String key = x + "#" + y;
                    map.put(key, map.getOrDefault(key, 1) + 1);
                }
            }
            max = Math.max(max, vertical);
            for (int count : map.values()) {
                max = Math.max(max, count + same);
            }
        }
        return max;
    }
}