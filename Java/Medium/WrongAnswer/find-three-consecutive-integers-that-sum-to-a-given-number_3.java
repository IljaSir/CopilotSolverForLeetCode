class Solution {
    public long[] sumOfThree(long num) {
        
        long[] result = new long[3];
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            result[i] = num - (2 - i);
            sum += result[i];
        }
        return sum == num ? result : new long[0];
    }
}