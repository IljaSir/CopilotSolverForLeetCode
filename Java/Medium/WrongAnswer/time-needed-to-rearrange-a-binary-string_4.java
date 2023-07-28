class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                i++;
                continue;
            }
            int j = i;
            while (j < s.length() && s.charAt(j) == '1') {
                j++;
            }
            count++;
            i = j;
        }
        return count;
    }
}