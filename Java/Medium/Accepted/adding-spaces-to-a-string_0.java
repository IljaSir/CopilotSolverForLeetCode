class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuilder sb = new StringBuilder(s);
        for (int i = spaces.length - 1; i >= 0; i--) {
            sb.insert(spaces[i], ' ');
        }
        return sb.toString();
    }
}