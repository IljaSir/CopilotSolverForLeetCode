class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int MOD = 1_000_000_007;
        int OPEN = 1, CLOSE = -1;
        int[][] events = new int[rectangles.length * 2][];
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
        }
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        //Active (open) intervals of x-coordinates
        TreeMap<Integer, Integer> active = new TreeMap();
        active.put(0, 1);
        int cur_x_sum = 0;
        long ans = 0;
        int cur_y = events[0][0];

        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];
            ans += cur_x_sum * 1L * (y - cur_y);

            if (typ == OPEN) {
                active.put(x1, active.getOrDefault(x1, 0) + 1);
                active.put(x2, active.getOrDefault(x2, 0) + 1);
            } else {
                active.put(x1, active.get(x1) - 1);
                if (active.get(x1) == 0) active.remove(x1);
                active.put(x2, active.get(x2) - 1);
                if (active.get(x2) == 0) active.remove(x2);
            }

            cur_x_sum = 0;
            int prev = -1;
            for (int x: active.keySet()) {
                if (prev >= 0)
                    cur_x_sum += Math.max(x - prev, 0);
                prev = x;
            }

            cur_y = y;
        }

        return (int) (ans % MOD);
    }
}