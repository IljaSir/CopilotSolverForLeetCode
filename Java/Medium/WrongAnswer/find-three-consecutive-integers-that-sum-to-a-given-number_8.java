class Solution {
    public long[] sumOfThree(long num) {
        
        long[] result = new long[3];
        if (num < 3) {
            return new long[0];
        }
        long sum = num - 3;
        long i = 1;
        while (sum > 0) {
            sum -= i;
            i++;
        }
        if (sum == 0) {
            result[0] = i - 1;
            result[1] = i;
            result[2] = i + 1;
        } else {
            result[0] = i - 2;
            result[1] = i - 1;
            result[2] = i;
        }
        return result;
    }
}