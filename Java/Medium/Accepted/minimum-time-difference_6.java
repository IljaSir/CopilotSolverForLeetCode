class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] minutes = new int[timePoints.size()];
        int i = 0;
        for (String timePoint : timePoints) {
            String[] time = timePoint.split(":");
            minutes[i++] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        Arrays.sort(minutes);
        int min = Integer.MAX_VALUE;
        for (i = 1; i < minutes.length; i++) {
            min = Math.min(min, minutes[i] - minutes[i - 1]);
        }
        return Math.min(min, minutes[0] + 24 * 60 - minutes[minutes.length - 1]);
    }
}