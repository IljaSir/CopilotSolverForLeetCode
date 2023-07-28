class Solution {
    public String greatestLetter(String s) {
        
        int[] upper = new int[26];
        int[] lower = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upper[c - 'A'] = 1;
            } else {
                lower[c - 'a'] = 1;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (upper[i] == 1 && lower[i] == 1) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}