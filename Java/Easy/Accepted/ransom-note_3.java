class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] count = new int[26];
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return false;
            }
        }
        return true;
    }
}