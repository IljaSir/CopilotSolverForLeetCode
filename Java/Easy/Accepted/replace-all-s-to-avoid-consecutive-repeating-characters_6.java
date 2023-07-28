class Solution {
    public String modifyString(String s) {
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                char prev = i == 0 ? ' ' : chars[i - 1];
                char next = i == chars.length - 1 ? ' ' : chars[i + 1];
                char c = 'a';
                while (c == prev || c == next) {
                    c++;
                }
                chars[i] = c;
            }
        }
        return new String(chars);
    }
}