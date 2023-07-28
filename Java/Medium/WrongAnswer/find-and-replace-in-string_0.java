class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (i < indices.length && j == indices[i]) {
                if (s.substring(j, j + sources[i].length()).equals(sources[i])) {
                    sb.append(targets[i]);
                    j += sources[i].length() - 1;
                } else {
                    sb.append(s.charAt(j));
                }
                i++;
            } else {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}