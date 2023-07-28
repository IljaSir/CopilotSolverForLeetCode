class Solution {
    public boolean checkIfPangram(String sentence) {
        
        if (sentence.length() < 26) {
            return false;
        }
        int[] alphabet = new int[26];
        for (char c : sentence.toCharArray()) {
            alphabet[c - 'a'] = 1;
        }
        for (int i : alphabet) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
}