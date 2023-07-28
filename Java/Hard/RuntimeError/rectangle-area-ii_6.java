class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        long res = 0, mod = (long)1e9 + 7;
        List<int[]> events = new ArrayList();
        for (int[] rec: rectangles) {
            events.add(new int[]{rec[1], rec[0], rec[2], 1});
            events.add(new int[]{rec[3], rec[0], rec[2], -1});
        }
        Collections.sort(events, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[3] - b[3]);
        TreeMap<Integer, Integer> map = new TreeMap();
        int preY = events.get(0)[0], preXSum = 0;
        for (int[] event: events) {
            int y = event[0], x1 = event[1], x2 = event[2], sig = event[3];
            res = (res + (long)preXSum * (y - preY)) % mod;
            preY = y;
            map.put(x1, map.getOrDefault(x1, 0) + sig);
            if (x2 != x1) map.put(x2, map.getOrDefault(x2, 0) - sig);
            if (sig == 1) preXSum += x2 - x1;
            while (map.lastEntry().getValue() == 0) {
                map.remove(map.lastKey());
                preXSum -= map.lastKey() - map.lowerKey(map.lastKey());
            }
        }
        return (int)res;
    }
}