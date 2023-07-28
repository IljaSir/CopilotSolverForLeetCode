class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int space: spaces) {
            sb.append(s.substring(index, space));
            sb.append(" ");
            index = space;
        }
        sb.append(s.substring(index));
        return sb.toString();
    }
}