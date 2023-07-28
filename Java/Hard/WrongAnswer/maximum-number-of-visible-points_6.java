class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        double[] angles = new double[points.size()];
        int same = 0;
        for (int i = 0; i < points.size(); i++) {
            List<Integer> p = points.get(i);
            if (p.get(0) == location.get(0) && p.get(1) == location.get(1)) {
                same++;
                continue;
            }
            angles[i] = Math.toDegrees(Math.atan2(p.get(1) - location.get(1), p.get(0) - location.get(0)));
            if (angles[i] < 0) {
                angles[i] += 360;
            }
        }
        Arrays.sort(angles);
        int i = 0, j = 0, res = 0;
        while (i < angles.length) {
            while (j < angles.length && angles[j] - angles[i] <= angle) {
                j++;
            }
            res = Math.max(res, j - i);
            i++;
        }
        return res + same;
    }
}