class Solution {
    public int distinctEchoSubstrings(String text) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if ((j - i) % 2 == 0) {
                    if (text.substring(i, (j - i) / 2 + i).equals(text.substring((j - i) / 2 + i, j))) {
                        set.add(text.substring(i, j));
                    }
                }
            }
        }
        return set.size();
    }
}