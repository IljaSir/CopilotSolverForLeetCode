class Solution {
    public int superPow(int a, int[] b) {
        
        return superPow(a, b, b.length);
    }
    
    private int superPow(int a, int[] b, int n) {
        if (n == 0) {
            return 1;
        }
        int last = b[n - 1];
        int part1 = myPow(a, last);
        int part2 = myPow(superPow(a, b, n - 1), 10);
        return (part1 * part2) % 1337;
    }
    
    private int myPow(int a, int k) {
        a %= 1337;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = (res * a) % 1337;
        }
        return res;
    }
}