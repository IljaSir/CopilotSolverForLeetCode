class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int max = 0;
        int count = 0;
        int prev = 0;
        char prevChar = 'a';
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= prevChar) {
                if (c > prevChar) {
                    if (prevChar == 'a') {
                        count++;
                    } else {
                        count = 1;
                    }
                } else {
                    count++;
                }
                if (c == 'u') {
                    max = Math.max(max, count);
                }
            } else {
                count = 0;
            }
            prevChar = c;
        }
        return max;
    }
}