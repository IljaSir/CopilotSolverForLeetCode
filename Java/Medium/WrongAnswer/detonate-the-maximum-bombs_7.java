class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int[][] events = new int[2*n][];
        for (int i = 0; i < n; i++) {
            events[2*i] = new int[]{bombs[i][0] - bombs[i][2], 1, i};
            events[2*i + 1] = new int[]{bombs[i][0] + bombs[i][2], -1, i};
        }
        Arrays.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int[] count = new int[n];
        int[] max = new int[n];
        int result = 0;
        for (int[] event : events) {
            int x = event[0];
            int type = event[1];
            int id = event[2];
            if (type == 1) {
                int r = bombs[id][2];
                int y = bombs[id][1];
                int best = 0;
                for (int i = 0; i < n; i++) {
                    if (count[i] > 0) {
                        int dx = x - bombs[i][0];
                        int dy = y - bombs[i][1];
                        if (dx * dx + dy * dy <= r * r) {
                            best = Math.max(best, max[i]);
                        }
                    }
                }
                max[id] = best + 1;
                result = Math.max(result, max[id]);
            } else {
                count[id] = 1;
            }
        }
        return result;
    }
}