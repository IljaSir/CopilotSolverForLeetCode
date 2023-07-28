class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        String w = "";
        for (String word : words) {
            w += word;
            if (w.length() >= s.length()) {
                break;
            }
        }
        return w.equals(s);
    }
}