class Solution {
    public int distinctEchoSubstrings(String text) {
        
        int n = text.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((j - i) % 2 == 0 && text.substring(i, j).equals(text.substring(j, j + (j - i) / 2))) {
                    set.add(text.substring(i, j));
                }
            }
        }
        return set.size();
    }
}