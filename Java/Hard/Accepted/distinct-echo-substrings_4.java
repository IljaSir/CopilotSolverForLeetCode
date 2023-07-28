class Solution {
    public int distinctEchoSubstrings(String text) {
        
        Set<String> set = new HashSet<>();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i;
                if (i + len + len <= n && text.substring(i, i + len).equals(text.substring(i + len, i + len + len))) {
                    set.add(text.substring(i, i + len));
                }
            }
        }
        return set.size();
    }
}