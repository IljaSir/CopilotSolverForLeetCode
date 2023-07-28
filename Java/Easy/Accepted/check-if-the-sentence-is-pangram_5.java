class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int[] alpha = new int[26];
        for (char c : sentence.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] == 0) {
                return false;
            }
        }
        return true;
    }
}