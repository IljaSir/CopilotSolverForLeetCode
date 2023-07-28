class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int n = s.length();
        int k = indices.length;
        int[] match = new int[n];
        Arrays.fill(match, -1);
        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < sources[i].length() && indices[i] + j < n && s.charAt(indices[i] + j) == sources[i].charAt(j)) {
                j++;
            }
            if (j == sources[i].length()) {
                match[indices[i]] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (match[i] != -1) {
                sb.append(targets[match[i]]);
                i += sources[match[i]].length() - 1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}