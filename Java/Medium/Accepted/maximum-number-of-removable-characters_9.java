class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int[] rs = new int[removable.length];
        for (int i = 0; i < removable.length; i++) {
            rs[i] = removable[i];
        }
        int lo = 0, hi = removable.length;
        while (lo < hi) {
            int mi = lo + (hi - lo + 1) / 2;
            if (isSub(s, p, rs, mi)) {
                lo = mi;
            } else {
                hi = mi - 1;
            }
        }
        return lo;
    }
    private boolean isSub(String s, String p, int[] rs, int k) {
        int j = 0;
        boolean[] rm = new boolean[s.length()];
        for (int i = 0; i < k; i++) {
            rm[rs[i]] = true;
        }
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!rm[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }
}