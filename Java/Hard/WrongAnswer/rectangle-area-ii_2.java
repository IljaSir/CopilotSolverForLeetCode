class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int MOD = 1000000007;
        int OPEN = 1, CLOSE = -1;
        int[][] events = new int[rectangles.length * 2][];
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        // sort by x1, x2
        TreeMap<Integer, Integer> map = new TreeMap();
        long cur_y = 0, cur_x_sum = 0;
        long ans = 0;
        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];
            long dy = y - cur_y;
            ans = (ans + cur_x_sum * dy) % MOD;
            cur_y = y;
            if (typ == OPEN) {
                map.put(x1, map.getOrDefault(x1, 0) + 1);
                map.put(x2, map.getOrDefault(x2, 0) + 1);
            } else {
                map.put(x1, map.get(x1) - 1);
                map.put(x2, map.get(x2) - 1);
                if (map.get(x1) == 0) map.remove(x1);
                if (map.get(x2) == 0) map.remove(x2);
            }

            cur_x_sum = 0;
            int prev = -1;
            for (int x: map.keySet()) {
                if (prev >= 0)
                    cur_x_sum += x - prev;
                prev = x;
            }
        }

        return (int) ans;
    }
}