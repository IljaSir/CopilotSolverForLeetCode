class Solution {
    public int minimumMoves(String s) {
        
        int count = 0;
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == 'X') {
                count++;
                i += 3;
            } else {
                i++;
            }
        }
        return count;
    }
}