class Solution {
    public long[] sumOfThree(long num) {
        
        if (num < 3) {
            return new long[0];
        }
        long[] result = new long[3];
        long a = num / 3;
        long b = a + 1;
        long c = b + 1;
        if (a + b + c == num) {
            result[0] = a;
            result[1] = b;
            result[2] = c;
        }
        return result;
    }
}