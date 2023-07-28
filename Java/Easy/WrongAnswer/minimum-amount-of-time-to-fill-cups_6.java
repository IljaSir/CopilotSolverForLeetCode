class Solution {
    public int fillCups(int[] amount) {
        
        int cold = amount[0];
        int warm = amount[1];
        int hot = amount[2];
        int seconds = 0;
        int max = Math.max(cold, Math.max(warm, hot));
        int min = Math.min(cold, Math.min(warm, hot));
        int mid = cold + warm + hot - max - min;
        
        if (max >= min + mid) {
            seconds = max + mid;
        } else {
            seconds = max + (min + mid - max) / 2 + (min + mid - max) % 2;
        }
        
        return seconds;
    }
}