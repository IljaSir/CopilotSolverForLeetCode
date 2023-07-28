class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int r = n & 1;
        while (n != 0) {
            n >>>= 1;
            int t = n & 1;
            if (t == r) {
                return false;
            }
            r = t;
        }
        return true;
    }
}