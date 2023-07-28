class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        int same = 0;
        List<Double> angles = new ArrayList();
        for (List<Integer> p : points) {
            int x = p.get(0) - location.get(0);
            int y = p.get(1) - location.get(1);
            if (x == 0 && y == 0) {
                same++;
                continue;
            }
            angles.add(Math.atan2(y, x) * 180 / Math.PI);
        }
        Collections.sort(angles);
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.add(angles.get(i) + 360);
        }
        int res = same;
        int i = 0;
        for (int j = 0; j < angles.size(); j++) {
            while (angles.get(j) - angles.get(i) > angle) {
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}