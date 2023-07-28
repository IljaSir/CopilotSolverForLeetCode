class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < spaces.length; i++) {
            sb.append(s.substring(idx, spaces[i]));
            sb.append(" ");
            idx = spaces[i];
        }
        sb.append(s.substring(idx));
        return sb.toString();
    }
}