class Solution {
    public String reformat(String s) {
        
        String letters = "";
        String numbers = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                numbers += s.charAt(i);
            } else {
                letters += s.charAt(i);
            }
        }
        if (Math.abs(numbers.length() - letters.length()) > 1) {
            return "";
        }
        if (numbers.length() > letters.length()) {
            return reformat(numbers, letters);
        } else {
            return reformat(letters, numbers);
        }
    }
    
    public String reformat(String s, String t) {
        String result = "";
        int i = 0;
        for (; i < t.length(); i++) {
            result += s.charAt(i);
            result += t.charAt(i);
        }
        if (i < s.length()) {
            result += s.charAt(i);
        }
        return result;
    }
}