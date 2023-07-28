class Solution {
    public boolean checkIfPangram(String sentence) {
        
        char[] letters = new char[26];
        for (int i = 0; i < sentence.length(); i++) {
            letters[sentence.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] == 0) {
                return false;
            }
        }
        return true;
    }
}