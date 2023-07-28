class Solution {
    public int clumsy(int n) {
        
        int k = 0;
        int res = 0;
        if(n <= 4) {
            if(n == 1) {
                res = 1;
            } else if(n == 2) {
                res = 2;
            } else if(n == 3) {
                res = 6;
            } else if(n == 4) {
                res = 7;
            }
        } else {
            res = n * (n - 1) / (n - 2);
            k = n - 3;
            while(k > 4) {
                res = res + k - (k - 1) * (k - 2) / (k - 3);
                k = k - 4;
            }
            if(k == 4) {
                res = res + k - (k - 1) * (k - 2) / (k - 3);
            } else if(k == 3) {
                res = res + k - (k - 1) * (k - 2);
            } else if(k == 2) {
                res = res + k - (k - 1);
            } else if(k == 1) {
                res = res + k;
            }
        }
        return res;
    }
}