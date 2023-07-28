class Solution {
    public String freqAlphabets(String s) {
        
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            if (c == '#') {
                int num = Integer.parseInt(s.substring(i - 2, i));
                sb.append((char)('a' + num - 1));
                i -= 3;
            } else {
                sb.append((char)('a' + c - '1'));
                i -= 1;
            }
        }
        return sb.reverse().toString();
    }
}