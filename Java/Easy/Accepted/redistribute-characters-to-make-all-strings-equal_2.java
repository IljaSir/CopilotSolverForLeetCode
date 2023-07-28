class Solution {
    public boolean makeEqual(String[] words) {
        
        int[] counts = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}