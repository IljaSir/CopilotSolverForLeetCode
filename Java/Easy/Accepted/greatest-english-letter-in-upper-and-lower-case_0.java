class Solution {
    public String greatestLetter(String s) {
        
        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upper[s.charAt(i) - 'A'] = true;
            } else {
                lower[s.charAt(i) - 'a'] = true;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (upper[i] && lower[i]) {
                return String.valueOf((char)(i + 'A'));
            }
        }
        return "";
    }
}