class Solution {
    public int[][] merge(int[][] intervals) {
        
        int len = intervals.length;
        if (len < 2) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] merged = new int[len][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || merged[index][1] < interval[0]) {
                merged[++index] = interval;
            } else {
                merged[index][1] = Math.max(merged[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(merged, index + 1);
    }
}