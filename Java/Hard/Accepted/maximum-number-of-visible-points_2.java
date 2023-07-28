class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        List<Double> angles = new ArrayList<>();
        int same = 0;
        for (List<Integer> point : points) {
            if (point.get(0) == location.get(0) && point.get(1) == location.get(1)) {
                same++;
                continue;
            }
            double rad = Math.atan2(point.get(1) - location.get(1), point.get(0) - location.get(0));
            angles.add(rad);
            angles.add(rad + 2 * Math.PI);
        }
        Collections.sort(angles);
        int res = same, i = 0;
        for (int j = 0; j < angles.size(); j++) {
            while (angles.get(j) - angles.get(i) > angle * Math.PI / 180) {
                i++;
            }
            res = Math.max(res, j - i + 1 + same);
        }
        return res;
    }
}