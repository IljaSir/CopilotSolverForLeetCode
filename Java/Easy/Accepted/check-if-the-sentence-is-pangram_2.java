class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int[] chars = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            chars[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) {
                return false;
            }
        }
        return true;
    }
}