class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            result[i] = entry == null ? -1 : entry.getValue();
        }
        return result;
    }
}