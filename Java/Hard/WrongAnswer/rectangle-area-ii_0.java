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
        // Sweep line: active set of x-coordinates
        // TreeMap: x, count
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(0, 1);
        long cur_x_sum = 0;
        long ans = 0;
        int cur_y = events[0][0];

        for (int[] event: events) {
            // Calculate answer from (cur_y, event_y)
            ans += cur_x_sum * (event[0] - cur_y);
            ans %= MOD;
            cur_y = event[0];

            if (event[1] == OPEN) {
                // Add interval
                map.put(event[2], map.getOrDefault(event[2], 0) + 1);
                map.put(event[3], map.getOrDefault(event[3], 0) + 1);
            } else {
                // Remove interval
                map.put(event[2], map.get(event[2]) - 1);
                if (map.get(event[2]) == 0)
                    map.remove(event[2]);
                map.put(event[3], map.get(event[3]) - 1);
                if (map.get(event[3]) == 0)
                    map.remove(event[3]);
            }

            // Update x-coord sum
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