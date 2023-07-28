class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        List<List<Long>> res = new ArrayList<>();
        int n = segments.length;
        List<int[]> events = new ArrayList<>();
        for (int[] seg: segments) {
            events.add(new int[]{seg[0], seg[2]});
            events.add(new int[]{seg[1], -seg[2]});
        }
        Collections.sort(events, (a, b) -> a[0] - b[0]);
        long total = 0, prev = 0;
        for (int[] e: events) {
            if (total > 0) {
                res.add(Arrays.asList(prev, (long) e[0], total));
            }
            total += e[1];
            prev = e[0];
        }
        return res;
    }
}