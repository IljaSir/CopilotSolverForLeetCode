class Solution {
    public int kthGrammar(int n, int k) {
        
        if (n == 1) {
            return 0;
        } else {
            int m = (int) Math.pow(2, n - 1);
            if (k <= m / 2) {
                return kthGrammar(n - 1, k);
            } else {
                return 1 - kthGrammar(n - 1, k - m / 2);
            }
        }
    }
}