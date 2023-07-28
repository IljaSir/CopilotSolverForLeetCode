class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int max = releaseTimes[0];
        char c = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int d = releaseTimes[i] - releaseTimes[i - 1];
            if (d > max) {
                max = d;
                c = keysPressed.charAt(i);
            } else if (d == max) {
                c = (char) Math.max(c, keysPressed.charAt(i));
            }
        }
        return c;
    }
}