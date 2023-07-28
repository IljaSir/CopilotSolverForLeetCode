class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        List<List<Long>> list = new ArrayList<>();
        TreeMap<Long, Long> map = new TreeMap<>();
        for (int[] seg : segments) {
            map.put((long) seg[0], map.getOrDefault((long) seg[0], 0L) + seg[2]);
            map.put((long) seg[1], map.getOrDefault((long) seg[1], 0L) - seg[2]);
        }
        long last = 0, sum = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (sum > 0) {
                list.add(Arrays.asList(last, entry.getKey(), sum));
            }
            sum += entry.getValue();
            last = entry.getKey();
        }
        return list;
    }
}