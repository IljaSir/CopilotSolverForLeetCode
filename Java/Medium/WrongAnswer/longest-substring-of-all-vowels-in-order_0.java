class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int max = 0;
        int count = 0;
        char prev = 'a';
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < prev) {
                prev = 'a';
                count = 0;
            }
            count++;
            if (c == 'u') {
                max = Math.max(max, count);
            }
            prev = c;
        }
        return max;
    }
}