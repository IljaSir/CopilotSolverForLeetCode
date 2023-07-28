class Solution {
    public int countSubstrings(String s, String t) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    continue;
                }
                int k = 0;
                while (i + k < s.length() && j + k < t.length() && s.charAt(i + k) == t.charAt(j + k)) {
                    k++;
                }
                count += k;
            }
        }
        return count;
    }
}