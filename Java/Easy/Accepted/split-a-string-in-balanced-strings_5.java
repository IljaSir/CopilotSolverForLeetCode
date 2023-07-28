class Solution {
    public int balancedStringSplit(String s) {
        
        int l = 0;
        int r = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                count++;
            }
        }
        return count;
    }
}