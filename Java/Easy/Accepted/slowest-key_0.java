class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int maxTime = releaseTimes[0];
        char maxChar = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);
            if (time > maxTime || (time == maxTime && c > maxChar)) {
                maxTime = time;
                maxChar = c;
            }
        }
        return maxChar;
    }
}