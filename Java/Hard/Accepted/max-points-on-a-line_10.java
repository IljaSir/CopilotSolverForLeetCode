class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.length;
        int max = 1;
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
                int a = p2[1] - p1[1];
                int b = p2[0] - p1[0];
                int gcd = gcd(a, b);
                String key = (a / gcd) + "/" + (b / gcd);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            max = Math.max(max, same + 1);
            for (String key : map.keySet()) {
                max = Math.max(max, map.get(key) + same + 1);
            }
        }
        return max;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}