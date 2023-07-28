class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        int[] res = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            int index = map.get(start);
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] < end) {
                j++;
            }
            if (j == intervals.length) {
                res[index] = -1;
            } else {
                res[index] = map.get(intervals[j][0]);
            }
        }
        return res;
    }
}