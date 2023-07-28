class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        int[] count = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            count[sum]++;
        }
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > result) {
                result = count[i];
            }
        }
        return result;
    }
}