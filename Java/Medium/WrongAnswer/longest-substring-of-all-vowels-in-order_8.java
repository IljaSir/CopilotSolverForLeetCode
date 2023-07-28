class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int max = 0;
        int count = 0;
        int prev = 0;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (i == 0) {
                prev = c;
                count ++;
                continue;
            }
            if (c == prev) {
                count ++;
            } else if (c > prev) {
                count ++;
                if (prev == 'a' && c == 'e') {
                    prev = c;
                } else if (prev == 'e' && c == 'i') {
                    prev = c;
                } else if (prev == 'i' && c == 'o') {
                    prev = c;
                } else if (prev == 'o' && c == 'u') {
                    prev = c;
                } else {
                    count = 0;
                    prev = 0;
                }
            } else {
                if (prev == 'u') {
                    max = Math.max(max, count);
                    count = 0;
                    prev = 0;
                } else {
                    count = 0;
                    prev = 0;
                }
            }
        }
        if (prev == 'u') {
            max = Math.max(max, count);
        }
        return max;
    }
}