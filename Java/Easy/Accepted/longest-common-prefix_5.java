class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        int maxPrefix = 0;
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return strs[0].substring(0, maxPrefix);
                }
            }
            maxPrefix++;
        }
        return strs[0].substring(0, maxPrefix);
    }
}