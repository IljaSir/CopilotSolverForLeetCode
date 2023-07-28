class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (j < indices.length && i == indices[j]) {
                if (s.startsWith(sources[j], i)) {
                    sb.append(targets[j]);
                    i += sources[j].length();
                    j++;
                } else {
                    sb.append(s.charAt(i));
                    i++;
                }
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}