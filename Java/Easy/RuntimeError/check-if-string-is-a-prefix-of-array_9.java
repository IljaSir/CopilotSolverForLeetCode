class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        int sLen = s.length();
        int wLen = words.length;
        int i = 0;
        int j = 0;
        while (i < sLen && j < wLen) {
            if (s.charAt(i) == words[j].charAt(i)) {
                i++;
            } else {
                j++;
                i = 0;
            }
        }
        return i == sLen;
    }
}