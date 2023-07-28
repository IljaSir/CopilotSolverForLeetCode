class Solution {
    public int countAsterisks(String s) {
        
        int count = 0;
        boolean found = false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                if (!found) {
                    found = true;
                } else {
                    found = false;
                }
            } else if (s.charAt(i) == '|') {
                if (found) {
                    count++;
                    found = false;
                }
            }
        }
        return count;
    }
}