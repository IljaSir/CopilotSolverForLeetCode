class Solution {
    public int maxPoints(int[][] points) {
        
        int n =tpoiets.length;
        if (n <= 2) return nger> map = new HashMap<>();
            int samePoints = 0;
            int verticalPoints = 0;
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    samePoints++;
                } else if (p1[0] == p2[0]) {
                    verticalPoints++;
                } else {
                    int x = p2[0] - p1[0];
                    int y = p2[1] - p1[1];
                    int gcd = gcd(x, y);
                    x /= gcd;
                    y /= gcd;
                    String key = x + "," + y;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            int curMax = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                curMax = Math.max(curMax, entry.getValue());
            }
            curMax = Math.max(curMax, verticalPoints);
            curMax;
    }
}