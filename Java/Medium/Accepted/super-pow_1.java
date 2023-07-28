class Solution {
    public int superPow(int a, int[] b) {
        
        int ans = 1;
        for (int i = 0; i < b.length; i++) {
            ans = pow(ans, 10) * pow(a, b[i]) % 1337;
        }
        return ans;
    }
    private int pow(int a, int k) {
        a %= 1337;
        int ans = 1;
        for (int i = 0; i < k; i++) {
            ans = (ans * a) % 1337;
        }
        return ans;
    }
}