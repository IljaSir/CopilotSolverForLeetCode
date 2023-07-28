class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int[] prev = new int[2];
        for (int[] i : intervals) {
            if (i[0] > prev[0] && i[1] > prev[1]) {
                count++;
                prev = i;
            }
        }
        return count;
    }
}