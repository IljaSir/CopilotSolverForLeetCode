class Solution {
    public int addDigits(int num) {
        
        while (num >= 10) {
            int sum = 0;
            while (num >= 10) {
                sum += num % 10;
                num /= 10;
            }
            sum += num;
            num = sum;
        }
        return num;
    }
}