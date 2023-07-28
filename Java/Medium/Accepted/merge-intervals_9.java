class Solution {
    public int[][] merge(int[][] intervals) {
        
        // sort the array based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // add the first interval to the result
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastInterval = result.get(result.size() - 1);
            
            if (currentInterval[0] <= lastInterval[1]) {
                // overlapping intervals, adjust the end time of the last interval
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                // non-overlapping interval, add to the result
                result.add(currentInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}