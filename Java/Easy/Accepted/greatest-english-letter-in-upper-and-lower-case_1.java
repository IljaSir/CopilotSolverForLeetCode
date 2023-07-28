class Solution {
    public String greatestLetter(String s) {
        
        int[] upper = new int[26];
        int[] lower = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upper[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                lower[c - 'a']++;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (upper[i] > 0 && lower[i] > 0) {
                return Character.toString((char) (i + 'A'));
            }
        }
        return "";
    }
}