class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int[] count = new int[26];
        int total = 0, max = 0;
        for (int i = 0; i < minSize; i++) {
            if (count[s.charAt(i) - 'a']++ == 0) total++;
        }
        if (total <= maxLetters) max = 1;
        for (int i = minSize; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a']++ == 0) total++;
            if (count[s.charAt(i - minSize) - 'a']-- == 1) total--;
            if (total <= maxLetters) max = Math.max(max, minSize - i + s.length());
        }
        return max;
    }
}