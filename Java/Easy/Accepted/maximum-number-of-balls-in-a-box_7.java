class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        int[] box = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int tmp = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            box[sum]++;
        }
        int max = 0;
        for (int i = 1; i < box.length; i++) {
            max = Math.max(max, box[i]);
        }
        return max;
    }
}