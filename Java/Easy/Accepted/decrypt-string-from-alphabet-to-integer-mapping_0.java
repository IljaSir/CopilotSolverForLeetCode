class Solution {
    public String freqAlphabets(String s) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) (Integer.parseInt(s.substring(i, i + 2)) + 'a' - 1));
                i += 2;
            } else {
                sb.append((char) (s.charAt(i) - '0' + 'a' - 1));
            }
        }
        return sb.toString();
    }
}