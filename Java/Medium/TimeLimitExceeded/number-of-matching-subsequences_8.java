class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int ans = 0;
        for (String word : words) {
            if (isSubseq(s, word)) ans++;
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return j == t.length();
    }
}