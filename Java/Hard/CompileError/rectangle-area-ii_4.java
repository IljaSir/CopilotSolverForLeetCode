class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int MOD = 1_000_000_007;
        int OPEN = 1, CLOSE = -1;
        int N = rectangles.length;

        int[][] events = new int[N*2][];
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
        }

        // Sort by y coordinate, then by event type
        // (OPEN before CLOSE events), and finally by x1.
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        // Sweep line: active = set of rectangles that are active
        // at this point of sweep line.
        // TreeMap: x-coordinate -> count
        TreeMap<Integer, Integer> active = new TreeMap();
        long ans = 0;
        int cur_y = events[0][0], cur_x_sum = 0;

        // Sweep over all events
        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];
            int x1i = active.floorKey(x1), x2i = active.floorKey(x2);

            // Update answer
            ans += (long) cur_x_sum * (y - cur_y);

            if (typ == OPEN) {
                // For OPEN events, we need to add the rectangle to "active".
                if (x1i != null && active.get(x1i) > 0)
                    // The rectangle starts from the left of some existing
                    // rectangle. We need to split the existing rectangle
                    // to two parts.
                    active.put(x1i, active.get(x1i) - 1);
                else
                    // The rectangle starts from the middle of nowhere.
                    // We need to add a new rectangle.
                    active.put(x1, active.getOrDefault(x1, 0) + 1);

                if (x2i !=
    }
}