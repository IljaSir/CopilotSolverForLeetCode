class Solution {
    public int superPow(int a, int[] b) {
        
        int[] pow = new int[10];
        pow[0] = 1;
        for (int i = 1; i < 10; i++) {
            pow[i] = pow[i - 1] * a % 1337;
        }
        int res = 1;
        for (int i = 0; i < b.length; i++) {
            res = pow[res % 10] * pow[b[i]] % 1337;
        }
        return res;
    }
}