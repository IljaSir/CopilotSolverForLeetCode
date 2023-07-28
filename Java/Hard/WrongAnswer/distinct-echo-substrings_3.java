class Solution {
    public int distinctEchoSubstrings(String text) {
        
        int n = text.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((j - i) % 2 == 0 && text.substring(i, (i + j) / 2).equals(text.substring((i + j) / 2, j))) {
                    set.add(text.substring(i, j));
                }
            }
        }
        return set.size();
    }
}