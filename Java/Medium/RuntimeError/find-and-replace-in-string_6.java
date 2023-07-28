class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int[] match = new int[s.length()];
        Arrays.fill(match, -1);
        for (int i = 0; i < indices.length; i++) {
            int start = indices[i];
            if (s.substring(start, start + sources[i].length()).equals(sources[i])) {
                match[start] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (match[i] >= 0) {
                sb.append(targets[match[i]]);
                i += sources[match[i]].length();
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}