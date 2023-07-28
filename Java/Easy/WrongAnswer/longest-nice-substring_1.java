class Solution {
    public String longestNiceSubstring(String s) {
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (sub.length() > result.length() && isNice(sub)) {
                    result = sub;
                }
            }
        }
        return result;
    }

    private boolean isNice(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                continue;
            }
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                continue;
            }
            return false;
        }
        return true;
    }
}