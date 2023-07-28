class Solution {
    public int distinctEchoSubstrings(String text) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if ((j - i) % 2 == 0) {
                    String s1 = text.substring(i, i + (j - i) / 2);
                    String s2 = text.substring(i + (j - i) / 2, j + 1);
                    if (s1.equals(s2)) {
                        set.add(s1);
                    }
                }
            }
        }
        return set.size();
    }
}