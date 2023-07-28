class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        int[] counts = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            counts[sumOfDigits(i)]++;
        }
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        return max;
    }
    
    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}