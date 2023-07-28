class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int max = releaseTimes[0];
        char slowest = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++){
            int dur = releaseTimes[i] - releaseTimes[i - 1];
            if(dur > max){
                max = dur;
                slowest = keysPressed.charAt(i);
            }else if(dur == max && keysPressed.charAt(i) > slowest){
                slowest = keysPressed.charAt(i);
            }
        }
        return slowest;
    }
}