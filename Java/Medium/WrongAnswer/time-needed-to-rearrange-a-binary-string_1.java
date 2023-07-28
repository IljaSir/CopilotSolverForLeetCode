class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return Math.min(count, n - count);
    }
}