class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuilder sb = new StringBuilder();
        int n = spaces.length;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < n && i == spaces[j]) {
                sb.append(' ');
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}