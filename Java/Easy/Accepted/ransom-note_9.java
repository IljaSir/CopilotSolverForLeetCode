class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] ransomLetters = new int[26];
        int[] magazineLetters = new int[26];
        for (char c : ransomNote.toCharArray()) {
            ransomLetters[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            magazineLetters[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ransomLetters[i] > magazineLetters[i]) {
                return false;
            }
        }
        return true;
    }
}