class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        for (int i = 0; i < indices.length; ++i) {
            int j = 0;
            for (; j < sources[i].length(); ++j) {
                if (s.charAt(indices[i] + j) != sources[i].charAt(j)) {
                    break;
                }
            }
            if (j == sources[i].length()) {
                match[indices[i]] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (match[i] >= 0) {
                sb.append(targets[match[i]]);
                i += sources[match[i]].length() - 1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}