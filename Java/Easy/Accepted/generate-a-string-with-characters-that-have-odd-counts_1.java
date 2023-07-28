class Solution {
    public String generateTheString(int n) {
        
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = 'a';
        }
        if (n % 2 == 0) {
            chars[0] = 'b';
        }
        return new String(chars);
    }
}