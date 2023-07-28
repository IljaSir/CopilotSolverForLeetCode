class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int n = removable.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(s, p, removable, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(String s, String p, int[] removable, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(removable[i]);
        }
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (!set.contains(i) && s.charAt(i) == p.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == p.length();
    }
}