class Solution {
    public int minTimeToType(String word) {
        
        int seconds = word.length();
        char prev = 'a';
        for (char c : word.toCharArray()) {
            int diff = Math.abs(c - prev);
            seconds += Math.min(diff, 26 - diff);
            prev = c;
        }
        return seconds;
    }
}