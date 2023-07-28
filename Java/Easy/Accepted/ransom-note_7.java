class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] letters = new int[26];
        for (char c : ransomNote.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            letters[c - 'a']--;
        }
        for (int i : letters) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}