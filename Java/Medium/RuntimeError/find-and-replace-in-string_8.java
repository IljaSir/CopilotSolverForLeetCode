class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int n = s.length();
        int m = indices.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int j = indices[i];
            if (s.substring(j, j + sources[i].length()).equals(sources[i])) {
                f[j] = i + n;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (f[i] >= n) {
                sb.append(targets[f[i] - n]);
                i += sources[f[i] - n].length() - 1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}