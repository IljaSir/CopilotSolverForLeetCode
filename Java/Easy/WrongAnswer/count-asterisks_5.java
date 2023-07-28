class Solution {
    public int countAsterisks(String s) {
        
        int count = 0;
        boolean foundPipe = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (foundPipe) {
                    count++;
                }
            } else {
                foundPipe = !foundPipe;
            }
        }
        return count;
    }
}