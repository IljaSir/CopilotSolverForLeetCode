class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int MOD = 1000000007;
        int OPEN = 0, CLOSE = 1;
        int[][] events = new int[rectangles.length * 2][];
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
        }
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        // Sort by x position
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(0, 1);
        long cur_y = events[0][0], cur_x_sum = 0, ans = 0;
        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];
            // Calculate answer with (y - cur_y) * cur_x_sum
            ans = (ans + (long) (y - cur_y) * cur_x_sum) % MOD;
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

            // Update x sum
            cur_x_sum = 0;
            int prev = -1;
            for (int x: map.keySet()) {
                if (prev >= 0)
                    cur_x_sum += Math.max(x - prev, 0);
                prev = x;
            }
        }

        return (int) ans;
    }
}