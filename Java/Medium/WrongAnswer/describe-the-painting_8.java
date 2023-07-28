class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        int n = segments.length;
        List<List<Long>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] seg = segments[i];
            ans.add(Arrays.asList((long) seg[0], (long) seg[1], (long) seg[2]));
        }
        Collections.sort(ans, (a, b) -> {
            return a.get(0).compareTo(b.get(0));
        });
        List<List<Long>> res = new ArrayList<>();
        long start = ans.get(0).get(0);
        long end = ans.get(0).get(1);
        long color = ans.get(0).get(2);
        for (int i = 1; i < ans.size(); i++) {
            List<Long> seg = ans.get(i);
            if (seg.get(0) <= end) {
                end = Math.max(end, seg.get(1));
                color += seg.get(2);
            } else {
                res.add(Arrays.asList(start, end, color));
                start = seg.get(0);
                end = seg.get(1);
                color = seg.get(2);
            }
        }
        res.add(Arrays.asList(start, end, color));
        return res;
    }
}