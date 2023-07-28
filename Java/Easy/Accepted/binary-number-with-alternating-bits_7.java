class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int last = n & 1;
        while (n != 0) {
            n = n >>> 1;
            int current = n & 1;
            if (current == last) {
                return false;
            }
            last = current;
        }
        return true;
    }
}