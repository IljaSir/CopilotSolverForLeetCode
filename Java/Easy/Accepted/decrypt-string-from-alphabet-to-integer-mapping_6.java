class Solution {
    public String freqAlphabets(String s) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char)('a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                i += 3;
            } else {
                sb.append((char)('a' + s.charAt(i) - '1'));
                i++;
            }
        }
        return sb.toString();
    }
}