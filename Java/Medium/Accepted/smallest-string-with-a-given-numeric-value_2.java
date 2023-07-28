class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = 'a';
        }
        for (int i = n - 1; i >= 0; i--) {
            int num = Math.min(26, k - i);
            chars[i] = (char) (chars[i] + num - 1);
            k -= num;
        }
        return new String(chars);
    }
}