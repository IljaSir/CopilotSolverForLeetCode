class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        int n = points.size();
        int count = 0;
        double[] angles = new double[n];
        for (int i = 0; i < n; i++) {
            List<Integer> p = points.get(i);
            if (p.get(0) == location.get(0) && p.get(1) == location.get(1)) {
                count++;
            } else {
                angles[i] = Math.toDegrees(Math.atan2(p.get(1) - location.get(1), p.get(0) - location.get(0)));
            }
        }
        Arrays.sort(angles);
        int res = count;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (angles[j] < 0) {
                angles[j] += 360;
            }
            double a = angles[j] + 360;
            while (a - angles[i] > angle) {
                i++;
            }
            res = Math.max(res, count + j - i + 1);
        }
        return res;
    }
}