class Solution {
    public int minimumNumbers(int num, int k) {
        
        if (num == 0) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        int res = 0;
        while (num > 0) {
            res++;
            num -= k;
        }
        if (num == 0) {
            return res;
        }
        return res + 1;
    }
}