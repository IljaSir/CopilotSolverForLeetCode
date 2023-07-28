class Solution {
    public int distMoney(int money, int children) {
        
        int n = children;
        int m = money;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (m >= 8 && (m - 8) / (n - i) != 3) {
                res++;
                m -= 8;
            } else {
                m -= 1;
            }
        }
        if (m > 0) {
            return -1;
        } else {
            return res;
        }
    }
}