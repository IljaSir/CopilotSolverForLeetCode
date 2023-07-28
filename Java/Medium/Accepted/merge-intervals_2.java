class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length <= 1) {
            return intervals;
        }
        // Sort by ascending starting point
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] interval1, final int[] interval2) {
                return Integer.compare(interval1[0], interval2[0]);
            }
        });
        List<int[]> merged = new LinkedList<int[]>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}