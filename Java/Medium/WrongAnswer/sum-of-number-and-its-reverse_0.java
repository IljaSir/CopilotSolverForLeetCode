class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        int n = num;
        int rev = 0;
        while (n > 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        return num == rev;
    }
}