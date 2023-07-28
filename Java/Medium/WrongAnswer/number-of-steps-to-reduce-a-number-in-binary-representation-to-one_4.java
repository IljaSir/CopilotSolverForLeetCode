class Solution {
    public int numSteps(String s) {
        
        int count = 0;
        int i = s.length() - 1;
        while (i > 0) {
            if (s.charAt(i) == '0') {
                i--;
            } else {
                while (i >= 0 && s.charAt(i) == '1') {
                    i--;
                    count++;
                }
                if (i > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}