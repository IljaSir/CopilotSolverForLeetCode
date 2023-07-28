class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = 'a';
            k--;
        }
        int i = n - 1;
        while (k > 0) {
            if (k >= 25) {
                chars[i--] = 'z';
                k -= 25;
            } else {
                chars[i--] = (char) ('a' + k);
                k = 0;
            }
        }
        return new String(chars);
    }
}