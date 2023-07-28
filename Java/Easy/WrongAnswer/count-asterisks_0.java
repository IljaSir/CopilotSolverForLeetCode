class Solution {
    public int countAsterisks(String s) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                count++;
            } else if (s.charAt(i) == '|') {
                i++;
            }
        }
        return count;
    }
}