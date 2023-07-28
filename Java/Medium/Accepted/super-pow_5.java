class Solution {
    public int superPow(int a, int[] b) {
        
        if (a == 0) {
            return 0;
        }
        if (b.length == 0) {
            return 1;
        }
        int lastDigit = b[b.length - 1];
        int[] newB = new int[b.length - 1];
        for (int i = 0; i < b.length - 1; i++) {
            newB[i] = b[i];
        }
        return pow(a, lastDigit) * pow(superPow(a, newB), 10) % 1337;
    }
    
    public int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        a %= 1337;
        int ans = 1;
        for (int i = 0; i < b; i++) {
            ans *= a;
            ans %= 1337;
        }
        return ans;
    }
}