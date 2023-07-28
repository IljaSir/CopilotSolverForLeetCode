class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int count = 0;
        int len = s.length();
        while (len > 0) {
            int temp = len;
            s = s.replaceAll("01", "");
            len = s.length();
            count++;
            if (len == temp) {
                return -1;
            }
        }
        return count - 1;
    }
}