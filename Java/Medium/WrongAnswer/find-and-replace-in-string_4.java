class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int n = s.length();
        int[][] intervals = new int[indices.length][2];
        for (int i = 0; i < indices.length; i++) {
            intervals[i][0] = indices[i];
            intervals[i][1] = indices[i] + sources[i].length();
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            sb.append(s.substring(i, start));
            if (s.substring(start, end).equals(sources[i])) {
                sb.append(targets[i]);
            } else {
                sb.append(s.substring(start, end));
            }
            i++;
        }
        sb.append(s.substring(intervals[intervals.length - 1][1]));
        return sb.toString();
    }
}