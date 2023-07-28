class Solution {
    public double minAreaFreeRect(int[][] points) {
        
        int n = points.length;
        double ans = Double.MAX_VALUE;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                    + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                int[] mid = new int[] {(points[i][0] + points[j][0]) / 2, (points[i][1] + points[j][1]) / 2};
                map.putIfAbsent(dis, new ArrayList<>());
                map.get(dis).add(mid);
            }
        }
        for (int dis : map.keySet()) {
            List<int[]> list = map.get(dis);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int[] mid1 = list.get(i);
                    int[] mid2 = list.get(j);
                    int[] p1 = new int[] {mid1[0] + mid2[0] - mid1[1] + mid2[1], mid1[1] + mid2[1] - mid1[0] + mid2[0]};
                    int[] p2 = new int[] {mid1[0] + mid2[0] - mid1[1] - mid2[1], mid1[1] + mid2[1] - mid1[0] - mid2[0]};
                    for (int[] p : points) {
                        if (Arrays.equals(p, p1)) {
                            double area = Math.sqrt(dis) * Math.sqrt((mid1[0] - mid2[0]) * (mid1[0] - mid2[0])
                                + (mid1[1] - mid2[1]) * (mid1[1] - mid2[1]));
                            ans = Math.min(ans, area);
                        }
                        if (Arrays.equals(p, p2)) {
                            double area = Math.sqrt(dis) * Math.sqrt((mid1[0] - mid2[0]) *
    }
}