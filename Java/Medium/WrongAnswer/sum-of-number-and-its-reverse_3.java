class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        int rev = 0;
        int temp = num;
        while(temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return num + rev == num;
    }
}