class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        int n = points.size();
        int same = 0;
        double[] angles = new double[n];
        for (int i = 0; i < n; i++) {
            List<Integer> p = points.get(i);
            if (p.get(0) == location.get(0) && p.get(1) == location.get(1)) {
                same++;
                continue;
            }
            angles[i] = Math.toDegrees(Math.atan2(p.get(1) - location.get(1), p.get(0) - location.get(0)));
            angles[i] = angles[i] < 0 ? 360 + angles[i] : angles[i];
        }
        Arrays.sort(angles);
        int res = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (angles[j] - angles[i] > angle) {
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res + same;
    }
}