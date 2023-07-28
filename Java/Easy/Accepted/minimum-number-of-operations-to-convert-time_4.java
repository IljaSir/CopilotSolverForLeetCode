class Solution {
    public int convertTime(String current, String correct) {
        
        int[] current_time = Arrays.stream(current.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] correct_time = Arrays.stream(correct.split(":")).mapToInt(Integer::parseInt).toArray();
        int current_minutes = current_time[0] * 60 + current_time[1];
        int correct_minutes = correct_time[0] * 60 + correct_time[1];
        int diff = correct_minutes - current_minutes;
        int[] steps = {60, 15, 5, 1};
        int count = 0;
        for (int i = 0; i < steps.length; i++) {
            count += diff / steps[i];
            diff %= steps[i];
        }
        return count;
    }
}