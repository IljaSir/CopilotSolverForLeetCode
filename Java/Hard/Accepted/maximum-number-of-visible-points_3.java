class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        List<Double> angles = new ArrayList<>();
        int overlap = 0;
        for (List<Integer> p : points) {
            int x = p.get(0) - location.get(0);
            int y = p.get(1) - location.get(1);
            if (x == 0 && y == 0) {
                overlap++;
                continue;
            }
            angles.add(Math.atan2(y, x) * 180 / Math.PI);
        }
        Collections.sort(angles);
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.add(angles.get(i) + 360);
        }
        int res = 0, l = 0, r = 0;
        while (r < angles.size()) {
            if (angles.get(r) - angles.get(l) <= angle) {
                res = Math.max(res, r - l + 1);
                r++;
            } else {
                l++;
            }
        }
        return res + overlap;
    }
}