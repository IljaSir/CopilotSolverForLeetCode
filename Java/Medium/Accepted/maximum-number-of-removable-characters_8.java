class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int lo = 0, hi = removable.length;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (isSubsequence(s, p, mid, removable)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean isSubsequence(String s, String p, int k, int[] removable) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(removable[i]);
        }
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!set.contains(i) && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }
}