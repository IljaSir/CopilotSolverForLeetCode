class Solution {
    public int numSteps(String s) {
        
        int i = s.length() - 1;
        int count = 0;
        while (i > 0) {
            if (s.charAt(i) == '1') {
                count++;
                while (i >= 0 && s.charAt(i) == '1') {
                    count++;
                    i--;
                }
                if (i >= 0) {
                    s = s.substring(0, i) + "1" + s.substring(i + 1);
                }
            } else {
                i--;
            }
        }
        return count;
    }
}