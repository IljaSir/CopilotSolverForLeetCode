class Solution {
    public int bitwiseComplement(int n) {
        
        if (n == 0) return 1;
        int m = 1;
        while (m < n) {
            m = (m << 1) + 1;
        }
        return m - n;
    }
}