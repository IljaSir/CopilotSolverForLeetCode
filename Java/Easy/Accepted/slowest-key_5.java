class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int max = releaseTimes[0];
        char c = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int d = releaseTimes[i] - releaseTimes[i - 1];
            if (d > max || (d == max && keysPressed.charAt(i) > c)) {
                max = d;
                c = keysPressed.charAt(i);
            }
        }
        return c;
    }
}