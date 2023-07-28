class Solution {
    public int minAreaRect(int[][] points) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.computeIfAbsent(point[0], x -> new HashSet<>()).add(point[1]);
        }
        int res = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] != p2[0] && p1[1] != p2[1] && map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    res = Math.min(res, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}