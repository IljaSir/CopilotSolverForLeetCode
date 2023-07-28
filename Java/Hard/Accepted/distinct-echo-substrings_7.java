class Solution {
    public int distinctEchoSubstrings(String text) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = 1; j <= (text.length() - i) / 2; j++) {
                String s = text.substring(i, i + j);
                if (text.substring(i + j).startsWith(s)) {
                    set.add(s);
                }
            }
        }
        return set.size();
    }
}