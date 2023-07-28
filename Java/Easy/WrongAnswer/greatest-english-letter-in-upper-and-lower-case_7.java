class Solution {
    public String greatestLetter(String s) {
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.contains(Character.toLowerCase(c) + "") && s.contains(Character.toUpperCase(c) + "")) {
                result = Character.toUpperCase(c) + "";
            }
        }
        return result;
    }
}