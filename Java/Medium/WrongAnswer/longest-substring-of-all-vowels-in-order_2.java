class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int max = 0;
        int count = 0;
        char prev = ' ';
        for (char c : word.toCharArray()) {
            if (c < prev) {
                count = 0;
            }
            if (c == 'a') {
                count = 1;
            } else if (count > 0 && c == prev + 1) {
                count++;
            }
            if (c == 'u' && count > max) {
                max = count;
            }
            prev = c;
        }
        return max;
    }
}