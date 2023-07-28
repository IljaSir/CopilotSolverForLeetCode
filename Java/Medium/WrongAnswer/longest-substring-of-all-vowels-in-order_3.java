class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int maxLen = 0;
        int len = 0;
        int lastChar = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a') {
                if (lastChar == 0) {
                    len++;
                } else {
                    len = 1;
                }
            } else if (ch == 'e') {
                if (lastChar == 1) {
                    len++;
                } else if (lastChar == 0) {
                    len = 0;
                } else {
                    maxLen = Math.max(maxLen, len);
                    len = 2;
                }
            } else if (ch == 'i') {
                if (lastChar == 2) {
                    len++;
                } else if (lastChar == 1) {
                    len = 0;
                } else {
                    maxLen = Math.max(maxLen, len);
                    len = 3;
                }
            } else if (ch == 'o') {
                if (lastChar == 3) {
                    len++;
                } else if (lastChar == 2) {
                    len = 0;
                } else {
                    maxLen = Math.max(maxLen, len);
                    len = 4;
                }
            } else if (ch == 'u') {
                if (lastChar == 4) {
                    len++;
                } else if (lastChar == 3) {
                    len = 0;
                } else {
                    maxLen = Math.max(maxLen, len);
                    len = 5;
                }
            } else {
                len = 0;
            }
            if (len > 0) {
                lastChar = len - 1;
            }
        }
        if (lastChar == 4) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}