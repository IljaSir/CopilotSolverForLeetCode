class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        int n = segments.length;
        List<List<Long>> ans = new ArrayList<>();
        if (n == 0) return ans;
        Map<Integer, Long> map = new TreeMap<>();
        for (int[] seg : segments) {
            map.put(seg[0], map.getOrDefault(seg[0], 0L) + seg[2]);
            map.put(seg[1], map.getOrDefault(seg[1], 0L) - seg[2]);
        }
        int start = 0;
        long sum = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            int pos = entry.getKey();
            long color = entry.getValue();
            if (sum > 0) {
                ans.add(Arrays.asList((long)start, (long)pos, sum));
            }
            sum += color;
            start = pos;
        }
        return ans;
    }
}