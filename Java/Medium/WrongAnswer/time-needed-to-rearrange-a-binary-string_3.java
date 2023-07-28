class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        int one = 0;
        int zero = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') {
                one++;
            } else {
                zero++;
            }
        }
        return Math.min(one, zero);
    }
}