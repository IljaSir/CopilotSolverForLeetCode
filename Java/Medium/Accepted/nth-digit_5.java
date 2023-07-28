class Solution {
    public int findNthDigit(int n) {
        
        if (n < 10) return n;
        int i = 1;
        while (n > 9 * Math.pow(10, i - 1) * i) {
            n -= 9 * Math.pow(10, i - 1) * i;
            i++;
        }
        int num = (int) Math.pow(10, i - 1) + (n - 1) / i;
        int index = (n - 1) % i;
        return Integer.toString(num).charAt(index) - '0';
    }
}