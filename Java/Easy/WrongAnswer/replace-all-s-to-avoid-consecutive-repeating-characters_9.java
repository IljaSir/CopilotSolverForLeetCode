class Solution {
    public String modifyString(String s) {
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?') {
                char pre = i > 0 ? s.charAt(i - 1) : ' ';
                char next = i < s.length() - 1 ? s.charAt(i + 1) : ' ';
                char replace = 'a';
                while (replace == pre || replace == next) {
                    replace++;
                }
                result += replace;
            } else {
                result += c;
            }
        }
        return result;
    }
}