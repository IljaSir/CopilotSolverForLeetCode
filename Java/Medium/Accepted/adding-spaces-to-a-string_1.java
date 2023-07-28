class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int space : spaces) {
            sb.append(s.substring(i, space));
            sb.append(' ');
            i = space;
        }
        sb.append(s.substring(i));
        return sb.toString();
    }
}