class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        List<Double> angles = new ArrayList<>();
        int overlap = 0;
        for (List<Integer> point : points) {
            if (point.get(0) == location.get(0) && point.get(1) == location.get(1)) {
                overlap++;
                continue;
            }
            double theta = Math.atan2(point.get(1) - location.get(1), point.get(0) - location.get(0)) * 180 / Math.PI;
            angles.add(theta);
            angles.add(theta + 360);
        }
        Collections.sort(angles);
        int left = 0, right = 0;
        int res = 0;
        while (right < angles.size()) {
            while (angles.get(right) - angles.get(left) > angle) {
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res + overlap;
    }
}