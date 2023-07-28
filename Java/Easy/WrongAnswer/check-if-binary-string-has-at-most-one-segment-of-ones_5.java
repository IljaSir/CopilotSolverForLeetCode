class Solution {
    public boolean checkOnesSegment(String s) {
        
        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (found) {
                    return false;
                }
                found = true;
            } else {
                found = false;
            }
        }
        return true;
    }
}