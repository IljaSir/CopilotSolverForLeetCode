class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] str = new char[n];
        for (int i = 0; i < n; i++) {
            str[i] = 'a';
        }
        k -= n;
        for (int i = n - 1; i >= 0; i--) {
            int x = Math.min(25, k);
            str[i] += x;
            k -= x;
        }
        return new String(str);
    }
}