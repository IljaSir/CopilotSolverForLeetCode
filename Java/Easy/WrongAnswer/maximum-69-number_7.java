class Solution {
    public int maximum69Number (int num) {
        
        int ans = 0;
        int count = 0;
        while (num > 0) {
            int n = num % 10;
            if (n == 6 && count == 0) {
                n = 9;
                count += 1;
            }
            ans = ans * 10 + n;
            num /= 10;
        }
        int res = 0;
        while (ans > 0) {
            int n = ans % 10;
            res = res * 10 + n;
            ans /= 10;
        }
        return res;
    }
}