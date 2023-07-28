class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int n = s.length();
        int k = indices.length;
        int[] match = new int[n];
        Arrays.fill(match, -1);
        for (int i = 0; i < k; i++) {
            int start = indices[i];
            int end = start + sources[i].length();
            if (end <= n && s.substring(start, end).equals(sources[i])) {
                match[start] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (match[i] != -1) {
                sb.append(targets[match[i]]);
                i += sources[match[i]].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}