class Solution {
    public int superPow(int a, int[] b) {
        
        int res = 1;
        for (int i : b) {
            res = pow(res, 10) * pow(a, i) % 1337;
        }
        return res;
    }
    private int pow(int a, int k) {
        a %= 1337;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = res * a % 1337;
        }
        return res;
    }
}