class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int count = 0;
        int n = s.length();
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && s.charAt(j) == '0') {
                j++;
            }
            count += (j - i) / 2;
            i = j;
            while (j < n && s.charAt(j) == '1') {
                j++;
            }
            i = j;
        }
        return count;
    }
}