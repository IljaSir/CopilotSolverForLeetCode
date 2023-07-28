class Solution {
    public String removeStars(String s) {
        
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                left[i] = prev;
            } else {
                prev = i;
                left[i] = prev;
            }
        }
        prev = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                right[i] = prev;
            } else {
                prev = i;
                right[i] = prev;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                int l = left[i];
                int r = right[i];
                if (l != -1) {
                    sb.setCharAt(l, ' ');
                }
                if (r != -1) {
                    sb.setCharAt(r, ' ');
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString().replaceAll(" ", "");
    }
}