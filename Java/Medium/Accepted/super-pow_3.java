class Solution {
    public int superPow(int a, int[] b) {
        
        if (a == 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        } else if (b.length == 0) {
            return 1;
        } else if (b.length == 1 && b[0] == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < b.length; i++) {
            result = powmod(result, 10) * powmod(a, b[i]) % 1337;
        }
        return result;
    }

    private int powmod(int a, int k) {
        a %= 1337;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = (result * a) % 1337;
        }
        return result;
    }
}