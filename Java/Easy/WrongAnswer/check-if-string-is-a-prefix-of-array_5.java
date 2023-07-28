class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        int i = 0;
        int j = 0;
        while(i < s.length() && j < words.length) {
            if(s.charAt(i) == words[j].charAt(i)) {
                i++;
                if(i == words[j].length()) {
                    j++;
                    i = 0;
                }
            } else {
                return false;
            }
        }
        return i == 0;
    }
}