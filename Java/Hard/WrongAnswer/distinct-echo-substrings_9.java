class Solution {
    public int distinctEchoSubstrings(String text) {
        
        int ans = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if ((j - i) % 2 == 0 && text.charAt(i) == text.charAt(j) && text.substring(i, (i + j) / 2 + 1).equals(text.substring((i + j) / 2 + 1, j + 1))) {
                    ans++;
                }
            }
        }
        return ans;
    }
}