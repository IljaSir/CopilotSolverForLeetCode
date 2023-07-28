class Solution {
    public boolean isItPossible(String word1, String word2) {
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            freq2[word2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0 && freq2[i] > 0) {
                count++;
            }
        }
        return (count >= word1.length() - 1 && count >= word2.length() - 1);
    }
}