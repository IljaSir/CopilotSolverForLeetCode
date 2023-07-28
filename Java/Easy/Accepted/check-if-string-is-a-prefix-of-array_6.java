class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        String tmp = "";
        for (String w : words) {
            tmp += w;
            if (tmp.equals(s)) {
                return true;
            }
        }
        return false;
    }
}