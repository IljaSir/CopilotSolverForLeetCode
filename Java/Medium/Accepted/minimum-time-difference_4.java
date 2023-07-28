class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] time = new int[timePoints.size()];
        int i = 0;
        for (String s : timePoints) {
            time[i++] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
        }
        Arrays.sort(time);
        int min = Integer.MAX_VALUE;
        for (i = 1; i < time.length; ++i) {
            min = Math.min(min, time[i] - time[i - 1]);
        }
        return Math.min(min, time[0] + 1440 - time[time.length - 1]);
    }
}