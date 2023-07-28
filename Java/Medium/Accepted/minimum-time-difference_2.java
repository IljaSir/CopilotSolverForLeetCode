class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] time = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] t = timePoints.get(i).split(":");
            time[i] = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
        Arrays.sort(time);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < time.length - 1; i++) {
            min = Math.min(min, time[i + 1] - time[i]);
        }
        return Math.min(min, (24 * 60 - time[time.length - 1]) + time[0]);
    }
}