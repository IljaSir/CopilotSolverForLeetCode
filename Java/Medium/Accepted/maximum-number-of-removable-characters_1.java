class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int l = 0, r = removable.length;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(s, p, removable, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(String s, String p, int[] removable, int k) {
        boolean[] remove = new boolean[s.length()];
        for (int i = 0; i < k; i++) {
            remove[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!remove[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }
}