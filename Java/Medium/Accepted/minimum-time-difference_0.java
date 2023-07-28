class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            minutes[i] = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        }
        Arrays.sort(minutes);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.length; i++) {
            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
        }
        minDiff = Math.min(minDiff, minutes[0] + 24 * 60 - minutes[minutes.length - 1]);
        return minDiff;
    }
}