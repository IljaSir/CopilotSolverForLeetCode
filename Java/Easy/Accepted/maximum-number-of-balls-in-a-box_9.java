class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        int[] counts = new int[46];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            counts[sum]++;
            max = Math.max(max, counts[sum]);
        }
        return max;
    }
}