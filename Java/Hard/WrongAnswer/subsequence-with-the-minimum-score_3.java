class Solution {
    public int minimumScore(String s, String t) {
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] < 0) {
                min = Math.min(min, -freq[i]);
            }
        }
        return min;
    }
}