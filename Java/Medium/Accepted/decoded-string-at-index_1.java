class Solution {
    public String decodeAtIndex(String s, int k) {
        
        long size = 0;
        int n = s.length();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            k %= size;
            if (k == 0 && Character.isLetter(s.charAt(i))) {
                return Character.toString(s.charAt(i));
            }
            if (Character.isDigit(s.charAt(i))) {
                size /= s.charAt(i) - '0';
            } else {
                size--;
            }
        }
        return null;
    }
}