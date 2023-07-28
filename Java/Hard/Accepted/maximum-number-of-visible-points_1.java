class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        List<Double> angles = new ArrayList<>();
        int overlap = 0;
        for (List<Integer> point : points) {
            int x = point.get(0) - location.get(0);
            int y = point.get(1) - location.get(1);
            if (x == 0 && y == 0) {
                overlap++;
                continue;
            }
            angles.add(Math.atan2(y, x) * 180 / Math.PI);
        }
        Collections.sort(angles);
        int n = angles.size();
        List<Double> newAngles = new ArrayList<>();
        for (double angle1 : angles) {
            newAngles.add(angle1 + 360);
        }
        angles.addAll(newAngles);
        int res = 0;
        int left = 0;
        for (int right = 0; right < angles.size(); right++) {
            while (angles.get(right) - angles.get(left) > angle) {
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res + overlap;
    }
}