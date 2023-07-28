class Solution {
    public int countSubstrings(String s, String t) {
        
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                ans += countSubstrings(s, t, i, j);
            }
        }
        return ans;
    }
    private int countSubstrings(String s, String t, int i, int j) {
        int ans = 0;
        int count = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                count++;
            }
            if (count > 1) {
                break;
            }
            if (count == 1) {
                ans++;
            }
            i++;
            j++;
        }
        return ans;
    }
}