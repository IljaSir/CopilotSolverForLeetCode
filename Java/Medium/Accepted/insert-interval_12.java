class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] ans = new int[intervals.length + 1][2];
        int i = 0;
        for (i = 0; i < intervals.length; i++) {
            if (newInterval[0] <= intervals[i][0]) {
                break;
            }
        }
        if (i < intervals.length) {
            System.arraycopy(intervals, 0, ans, 0, i);
            ans[i] = newInterval;
            System.arraycopy(intervals, i, ans, i + 1, intervals.length - i);
        } else {
            System.arraycopy(intervals, 0, ans, 0, intervals.length);
            ans[i] = newInterval;
        }
        List<int[]> list = new ArrayList<>();
        for (int[] interval : ans) {
            if (list.size() == 0 || list.get(list.size() - 1)[1] < interval[0]) {
                list.add(interval);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}