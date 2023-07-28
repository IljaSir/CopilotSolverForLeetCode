class Solution {
    public int splitNum(int num) {
        
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        int sum = 0;
        int carry = 0;
        for (int i = 1; i < 10; i++) {
            sum += i * (count[i] + carry);
            carry = (count[i] + carry) % 2;
        }
        return sum;
    }
}