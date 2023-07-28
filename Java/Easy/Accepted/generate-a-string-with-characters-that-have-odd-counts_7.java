class Solution {
    public String generateTheString(int n) {
        
        char[] chars = new char[n];
        if (n % 2 == 1) {
            Arrays.fill(chars, 'a');
        } else {
            Arrays.fill(chars, 0, n - 1, 'a');
            chars[n - 1] = 'b';
        }
        return new String(chars);
    }
}