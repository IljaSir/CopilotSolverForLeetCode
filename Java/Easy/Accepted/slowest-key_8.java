class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        char maxChar = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i=1; i<releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i-1];
            if (time > maxTime) {
                maxTime = time;
                maxChar = keysPressed.charAt(i);
            } else if (time == maxTime) {
                maxChar = (char) Math.max(maxChar, keysPressed.charAt(i));
            }
        }
        return maxChar;
    }
}