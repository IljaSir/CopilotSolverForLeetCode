class Solution {
    public String longestNiceSubstring(String s) {
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isNice(sub) && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }
        return result;
    }
    
    private boolean isNice(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) {
                return false;
            }
            if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }
}