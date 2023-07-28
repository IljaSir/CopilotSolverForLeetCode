class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int lo = 0, hi = removable.length;
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            if (isSubsequence(s, p, removable, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    public boolean isSubsequence(String s, String p, int[] removable, int k) {
        boolean[] marked = new boolean[s.length()];
        for (int i = 0; i < k; i++) marked[removable[i]] = true;
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (!marked[i] && s.charAt(i) == p.charAt(j)) j++;
            i++;
        }
        return j == p.length();
    }
}