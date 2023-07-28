class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        int max = 0;
        for (int[] pos : positions) {
            int left = pos[0], len = pos[1], right = left + len;
            Integer start = map.floorKey(left), end = map.floorKey(right);
            if (start == null) start = 0;
            int h = 0;
            for (int key : map.subMap(start, false, end, true).keySet()) {
                h = Math.max(h, map.get(key));
            }
            h += len;
            map.put(left, h);
            map.put(right, map.get(start));
            max = Math.max(max, h);
            res.add(max);
        }
        return res;
    }
}