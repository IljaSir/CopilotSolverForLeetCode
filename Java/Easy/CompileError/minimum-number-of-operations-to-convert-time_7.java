class Solution {
    public int convertTime(String current, String correct) {
        
        int[] time1 = getTime(current);
        int[] time2 = getTime(correct);
        int time1inMin = time1[0] * 60 + time1[1];
        int time2inMin = time2[0] * 60 + time2[1];
        int diff = time2inMin - time1inMin;
        int[] minutes = {1, 5, 15, 60};
        int result = 0;
        for(int i = minutes.length - 1; i >= 0; i--) {
            int min = minutes[i];
            int count = diff / min;
            result += count;
            diff -= min * count;
        }
        return result;
    }
}