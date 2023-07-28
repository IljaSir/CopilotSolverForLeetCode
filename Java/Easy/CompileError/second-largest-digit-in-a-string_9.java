class Solution {
    public int secondHighest(String s) {
        
        int f = -1, s = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (digit > f) {
                    s = f;
                    f = digit;
                } else if (digit > s && digit != f) {
                    s = digit;
                }
            }
        }
        return s;
    }
}