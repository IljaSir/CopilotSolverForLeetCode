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
        i = 0;
        j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n && j < n) {
            if (s.charAt(i) < s.charAt(j)) {
                sb.append(s.charAt(i++));
            } else if (s.charAt(i) > s.charAt(j)) {
                sb.append(s.charAt(j++));
            } else {
                int k = 0;
                while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                }
                if (i + k == n) {
                    sb.append(s.charAt(j++));
                } else if (j + k == n) {
                    sb.append(s.charAt(i++));
                } else if (s.charAt(i + k) < s.charAt(j + k)) {
                    sb.append(s.charAt(i++));
                } else {
                    sb.append(s.charAt(j++));
                }
            }
        }
        while (i < n) {
            sb.append(s.charAt(i++));
        }
        while (j < n) {
            sb.append(s.charAt(j++));
        }
        return sb.toString();
    }
}