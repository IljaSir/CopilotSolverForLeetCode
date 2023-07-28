class Solution {
    public int balancedStringSplit(String s) {
        
        int result = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result++;
            }
        }
        return result;
    }
}