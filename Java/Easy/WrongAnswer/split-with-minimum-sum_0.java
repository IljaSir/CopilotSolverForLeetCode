class Solution {
    public int splitNum(int num) {
        
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            if (count[i] > 0) {
                sum += i;
                count[i]--;
                break;
            }
        }
        for (int i = 0; i <= 9; i++) {
            sum += i * count[i];
        }
        return sum;
    }
    public int minSumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, splitNum(num));
        }
        return min % 2 == 0 ? 1 : 0;
    }
}