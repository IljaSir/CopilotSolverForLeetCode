class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int last = n & 1;
        n >>= 1;
        while (n != 0) {
            if (last == (n & 1)) {
                return false;
            }
            last = n & 1;
            n >>= 1;
        }
        return true;
    }
}