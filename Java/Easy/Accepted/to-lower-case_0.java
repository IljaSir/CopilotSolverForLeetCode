class Solution {
    public String toLowerCase(String s) {
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                result += (char) (s.charAt(i) - 'A' + 'a');
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}