class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] minutes = new int[timePoints.size()];
        int i = 0;
        for(String time: timePoints) {
            String[] timeArray = time.split(":");
            minutes[i] = Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
            i++;
        }
        Arrays.sort(minutes);
        int minDiff = Integer.MAX_VALUE;
        for(int j = 0; j < minutes.length - 1; j++) {
            int diff = minutes[j+1] - minutes[j];
            if(diff < minDiff) {
                minDiff = diff;
            }
        }
        int diff = 1440 - minutes[minutes.length - 1] + minutes[0];
        if(diff < minDiff) {
            minDiff = diff;
        }
        return minDiff;
    }
}