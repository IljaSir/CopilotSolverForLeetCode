class Solution {
    public int minAreaRect(int[][] points) {
        
        int ans = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : points) {
            map.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }
        for(int i = 0; i < points.length; i++) {
            for(int j = i+1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                if(p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    ans = Math.min(ans, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}