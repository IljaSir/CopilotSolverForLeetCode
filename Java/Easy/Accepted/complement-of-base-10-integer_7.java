class Solution {
    public int bitwiseComplement(int n) {
        
        if (n == 0) {
            return 1;
        }
        int i = 0;
        int ans = 0;
        while (n > 0) {
            int rem = n % 2;
            n = n / 2;
            if (rem == 0) {
                ans += Math.pow(2, i);
            }
            i++;
        }
        return ans;
    }
}