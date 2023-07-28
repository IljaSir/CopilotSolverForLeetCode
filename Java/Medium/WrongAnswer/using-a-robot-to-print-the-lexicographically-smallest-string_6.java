class Solution {
    public String robotWithString(String s) {
        
        int n = s.length();
        int[] next = new int[n];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < n - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        int t = 0;
        while (t < n) {
            if (sb.length() == 0 || s.charAt(t) <= sb.charAt(sb.length() - 1)) {
                sb.append(s.charAt(t++));
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}