class Solution {
    public int bitwiseComplement(int n) {
        
        if(n == 0) return 1;
        int res = 0;
        int i = 0;
        while(n > 0) {
            int t = n % 2;
            if(t == 0) res += Math.pow(2, i);
            n /= 2;
            i++;
        }
        return res;
    }
}