class Solution {
    public int distinctEchoSubstrings(String text) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 2; j <= text.length(); j += 2) {
                String s = text.substring(i, j);
                if (s.substring(0, s.length() / 2).equals(s.substring(s.length() / 2, s.length()))) {
                    set.add(s);
                }
            }
        }
        return set.size();
    }
}