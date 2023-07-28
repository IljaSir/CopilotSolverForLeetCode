class Solution {
    public String greatestLetter(String s) {
        
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                lower.add(c);
            } else {
                upper.add(c);
            }
        }
        for (char c = 'Z'; c >= 'A'; c--) {
            if (lower.contains(Character.toLowerCase(c)) && upper.contains(c)) {
                return String.valueOf(c);
            }
        }
        return "";
    }
}