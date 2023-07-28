class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        int rev = 0;
        int n = num;
        while (n > 0) {
            int d = n % 10;
            rev = rev * 10 + d;
            n /= 10;
        }
        return num + rev == num;
    }
}