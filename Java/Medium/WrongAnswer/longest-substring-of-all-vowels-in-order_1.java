class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int max = 0;
        int count = 0;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (c == 'a') {
                count = 1;
                while (i < word.length() - 1 && word.charAt(i + 1) >= c) {
                    if (word.charAt(i + 1) > c) {
                        count++;
                        c = word.charAt(i + 1);
                    }
                    i++;
                }
                if (count == 5) {
                    max = Math.max(max, i - count + 2);
                }
            }
            i++;
        }
        return max;
    }
}