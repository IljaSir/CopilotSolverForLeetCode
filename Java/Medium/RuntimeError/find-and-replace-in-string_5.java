class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int n = s.length();
        int m = indices.length;
        int[] match = new int[n];
        Arrays.fill(match, -1);
        for (int i = 0; i < m; i++) {
            int index = indices[i];
            String source = sources[i];
            if (s.substring(index, index + source.length()).equals(source)) {
                match[index] = i;
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