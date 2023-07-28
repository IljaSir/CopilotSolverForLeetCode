class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int space : spaces) {
            sb.append(s, i, space).append(' ');
            i = space;
        }
        sb.append(s, i, s.length());
        return sb.toString();
    }
}