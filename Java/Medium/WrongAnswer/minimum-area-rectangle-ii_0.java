class Solution {
    public double minAreaFreeRect(int[][] points) {
        
        int n = points.length;
        double res = Double.MAX_VALUE;
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i], p2 = points[j];
                int x = p1[0] + p2[0], y = p1[1] + p2[1];
                String key = x + "," + y;
                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(new int[]{i, j});
            }
        }
        for (Map.Entry<String, List<int[]>> entry : map.entrySet()) {
            List<int[]> list = entry.getValue();
            int m = list.size();
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    int[] p1 = points[list.get(i)[0]], p2 = points[list.get(i)[1]];
                    int[] p3 = points[list.get(j)[0]], p4 = points[list.get(j)[1]];
                    double area = Math.sqrt(Math.pow(p1[0] - p3[0], 2) + Math.pow(p1[1] - p3[1], 2)) * Math.sqrt(Math.pow(p1[0] - p4[0], 2) + Math.pow(p1[1] - p4[1], 2));
                    res = Math.min(res, area);
                }
            }
        }
        return res == Double.MAX_VALUE ? 0 : res;
    }
}