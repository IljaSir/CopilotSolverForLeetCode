class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        List<List<Long>> res = new ArrayList<>();
        Map<Integer, Long> map = new HashMap<>();
        for (int[] seg : segments) {
            map.put(seg[0], map.getOrDefault(seg[0], 0L) + seg[2]);
            map.put(seg[1], map.getOrDefault(seg[1], 0L) - seg[2]);
        }
        int start = 0;
        long total = 0;
        for (int i : map.keySet()) {
            if (total > 0) {
                res.add(Arrays.asList((long)start, (long)i, total));
            }
            start = i;
            total += map.get(i);
        }
        return res;
    }
}