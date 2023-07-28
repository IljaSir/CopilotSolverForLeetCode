class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int max = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            if (duration > max) {
                max = duration;
                ans = keysPressed.charAt(i);
            } else if (duration == max) {
                ans = (char) Math.max(ans, keysPressed.charAt(i));
            }
        }
        return ans;
    }
}