class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        List<Double> angles = new ArrayList<>();
        int same = 0;
        for (List<Integer> point : points) {
            int x = point.get(0) - location.get(0);
            int y = point.get(1) - location.get(1);
            if (x == 0 && y == 0) {
                same++;
                continue;
            }
            double ang = Math.atan2(y, x) * 180 / Math.PI;
            if (ang < 0) {
                ang += 360;
            }
            angles.add(ang);
        }
        Collections.sort(angles);
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.add(angles.get(i) + 360);
        }
        int res = 0;
        int left = 0;
        for (int right = 0; right < angles.size(); right++) {
            while (angles.get(right) - angles.get(left) > angle) {
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res + same;
    }
}