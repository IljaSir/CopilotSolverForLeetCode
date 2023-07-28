class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] minutes = new int[timePoints.size()];
        int i = 0;
        for (String time : timePoints) {
            minutes[i++] = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        }
        Arrays.sort(minutes);
        int min = Integer.MAX_VALUE;
        for (i = 1; i < minutes.length; i++) {
            min = Math.min(min, minutes[i] - minutes[i - 1]);
        }
        return Math.min(min, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }
}