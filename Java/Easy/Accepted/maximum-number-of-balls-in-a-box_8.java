class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        int[] counts = new int[46];
        for (int i = lowLimit; i <= highLimit; ++i) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += j % 10;
            }
            counts[sum]++;
        }
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        return max;
    }
}