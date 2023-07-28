class Solution {
    public int countSubstrings(String s, String t) {
        
        int count = 0;
        int n = s.length();
        int m = t.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = 0;
                int k = 0;
                while (i + k < n && j + k < m) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        diff++;
                    }
                    if (diff > 1) {
                        break;
                    }
                    if (diff == 1) {
                        count++;
                    }
                    k++;
                }
            }
        }
        return count;
    }
}