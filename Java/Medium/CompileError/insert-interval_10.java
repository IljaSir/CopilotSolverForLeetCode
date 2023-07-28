class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        // add all intervals ending before newInterval starts
        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        // merge all overlapping intervals to one considering newInterval
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < len) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][] < newInterval[0]) {
            ans.add(intervals[i++]);
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while (i < n) {
            ans.add(intervals[i++]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}