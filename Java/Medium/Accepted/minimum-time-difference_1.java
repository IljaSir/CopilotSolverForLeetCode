class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }
        Arrays.sort(minutes);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.length; i++) {
            min = Math.min(min, minutes[i] - minutes[i - 1]);
        }
        min = Math.min(min, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
        return min;
    }
}