class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        int i = 0;
        for (String word : words) {
            if (i + word.length() > s.length())
                return false;
            if (!s.substring(i, i + word.length()).equals(word))
                return false;
            i += word.length();
        }
        return i == s.length();
    }
}