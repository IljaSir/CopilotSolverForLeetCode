class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        
        int[] result = new int[points.length];
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int[] rec : rectangles) {
            map.put(rec[0], map.getOrDefault(rec[0], 0) + 1);
            map.put(rec[1], map.getOrDefault(rec[1], 0) - 1);
        }
        int count = 0;
        int[] heights = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            heights[i++] = count += map.get(key);
        }
        for (i = 0; i < points.length; i++) {
            int[] p = points[i];
            int left = 0, right = heights.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (map.keySet().toArray()[mid] < p[0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left > 0 && map.keySet().toArray()[left] > p[0]) {
                left--;
            }
            if (map.keySet().toArray()[left] <= p[0]) {
                result[i] = heights[left];
            }
        }
        return result;
    }
}