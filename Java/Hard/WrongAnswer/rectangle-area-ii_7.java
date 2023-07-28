class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int mod = 1000000007;
        long res = 0;
        List<int[]> events = new ArrayList<>();
        for (int[] rec: rectangles) {
            events.add(new int[]{rec[1], rec[0], rec[2], 1});
            events.add(new int[]{rec[3], rec[0], rec[2], -1});
        }
        Collections.sort(events, (a,b) -> a[0] - b[0]);
        List<int[]> active = new ArrayList<>();
        int cur_y = events.get(0)[0];
        for (int[] e: events) {
            int y = e[0], x1 = e[1], x2 = e[2], sig = e[3];
            res = (res + (long) (y - cur_y) * getWidth(active)) % mod;
            cur_y = y;
            if (sig == 1) {
                active.add(new int[]{x1, x2});
                active.sort((a,b) -> a[0] - b[0]);
                merge(active);
            } else {
                for (int i = 0; i < active.size(); ++i) {
                    if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
                        active.remove(i);
                        break;
                    }
                }
            }
        }
        return (int) res;
    }
    public int getWidth(List<int[]> active) {
        int res = 0, cur_x = -1;
        for (int[] seg: active) {
            res += Math.max(0, seg[1] - Math.max(cur_x, seg[0]));
            cur_x = Math.max(cur_x, seg[1]);
        }
        return res;
    }
    public void merge(List<int[]> active) {
        for (int i = active.size() - 1; i > 0; --i) {
            int[] cur = active.get(i), pre = active.get(i - 1);
            if (pre[1] >= cur[0]) {
                pre[1] = Math.max(pre[1], cur[1]);
                active.remove(i);
            }
        }
    }
}