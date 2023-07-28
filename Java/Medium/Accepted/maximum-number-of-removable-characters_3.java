class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int l = 0;
        int r = removable.length;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (isSubsequence(s, p, removable, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    public boolean isSubsequence(String s, String p, int[] removable, int m) {
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < m; i++) {
            removed[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }
}