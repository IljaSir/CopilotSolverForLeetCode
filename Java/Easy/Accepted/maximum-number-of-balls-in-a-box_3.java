class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        int[] count = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            count[getSum(i)]++;
        }
        int max = 0;
        for (int i : count) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}