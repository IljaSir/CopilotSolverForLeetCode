class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = 'a';
        }
        k -= n;
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) {
                break;
            }
            int x = Math.min(k, 25);
            chars[i] += x;
            k -= x;
        }
        return new String(chars);
    }
}