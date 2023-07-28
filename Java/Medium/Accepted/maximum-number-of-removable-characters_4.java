class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int n = removable.length;
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (check(s, p, removable, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    private boolean check(String s, String p, int[] removable, int k) {
        int n = s.length();
        boolean[] remove = new boolean[n];
        for (int i = 0; i < k; i++) {
            remove[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < n && j < p.length(); i++) {
            if (remove[i]) {
                continue;
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }
}