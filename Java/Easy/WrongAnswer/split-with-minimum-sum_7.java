class Solution {
    public int splitNum(int num) {
        
        int[] digitFreq = new int[10];
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            digitFreq[digit]++;
            sum += digit;
            num /= 10;
        }
        int res = 0;
        int carry = 0;
        for (int i = 0; i < 10; i++) {
            int freq = digitFreq[i];
            if (freq > 0) {
                int oddFreq = freq % 2;
                int evenFreq = freq / 2;
                res += (i * (oddFreq + 2 * evenFreq));
                carry += (digitFreq[i] % 2);
            }
        }
        return res + carry;
    }
    public int minSumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, splitNum(num));
        }
        return min;
    }
}