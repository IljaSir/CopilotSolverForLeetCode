class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int count = 0;
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '0') {
                count++;
            } else {
                count--;
            }
            i++;
        }
        return Math.abs(count);
    }
}