class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int count = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == '0') {
                i++;
            } else {
                i++;
                while (i < len && s.charAt(i) == '1') {
                    i++;
                }
                count++;
            }
        }
        return count;
    }
}