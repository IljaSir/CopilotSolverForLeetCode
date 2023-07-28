class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        int i = 0;
        for (String word : words) {
            if (i + word.length() > s.length()) {
                return false;
            }
            for (int j = 0; j < word.length(); ++j) {
                if (s.charAt(i + j) != word.charAt(j)) {
                    return false;
                }
            }
            i += word.length();
        }
        return i == s.length();
    }
}