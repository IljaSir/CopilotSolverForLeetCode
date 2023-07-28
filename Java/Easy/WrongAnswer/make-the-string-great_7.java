class Solution {
    public String makeGood(String s) {
        
        String output = "";
        int i = 0;
        while (i < s.length()) {
            if (i == s.length() - 1) {
                output += s.charAt(i);
                break;
            }
            if (s.charAt(i) == s.charAt(i + 1) + 32 || s.charAt(i) == s.charAt(i + 1) - 32) {
                i += 2;
            } else {
                output += s.charAt(i);
                i++;
            }
        }
        return output;
    }
}