class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.length();
        int[] freq = new int[26];
        int res = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (freq[s.charAt(i) - 'a']++ == 0) {
                count++;
            }
            if (i >= minSize && --freq[s.charAt(i - minSize) - 'a'] == 0) {
                count--;
            }
            if (i >= minSize - 1 && count <= maxLetters) {
                res++;
            }
        }
        return res;
    }
}