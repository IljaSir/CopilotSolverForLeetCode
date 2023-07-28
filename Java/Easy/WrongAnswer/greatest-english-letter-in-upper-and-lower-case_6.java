class Solution {
    public String greatestLetter(String s) {
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) != -1 && s.indexOf(Character.toUpperCase(c)) != -1) {
                result += c;
            }
        }
        return result;
    }
}