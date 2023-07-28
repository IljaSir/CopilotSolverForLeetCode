class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        int same = 0;
        List<Double> angles = new ArrayList<>();
        for (List<Integer> p : points) {
            if (p.get(0) == location.get(0) && p.get(1) == location.get(1)) {
                same++;
                continue;
            }
            double a = Math.toDegrees(Math.atan2(p.get(1) - location.get(1), p.get(0) - location.get(0)));
            angles.add(a);
            angles.add(a + 360);
        }
        Collections.sort(angles);
        int ans = 0;
        int i = 0;
        for (int j = 0; j < angles.size(); ++j) {
            while (angles.get(j) - angles.get(i) > angle) {
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans + same;
    }
}