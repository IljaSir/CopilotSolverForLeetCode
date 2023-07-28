class Solution {
    public long[] sumOfThree(long num) {
        
        long[] result = new long[3];
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            result[i] = num - i;
            sum += result[i];
        }
        if (sum == num) {
            return result;
        }
        return new long[0];
    }
}