class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(freq1[i] - freq2[i]);
        }
        return diff <= 6;
    }
}