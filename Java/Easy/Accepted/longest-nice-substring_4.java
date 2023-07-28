class Solution {
    public String longestNiceSubstring(String s) {
        
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (isNice(sub) && sub.length() > res.length()) {
                    res = sub;
                }
            }
        }
        return res;
    }

    private boolean isNice(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c))) {
                return false;
            }
            if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) {
                return false;
            }
        }
        return true;
    }
}