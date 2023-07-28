class Solution {
    public long[] sumOfThree(long num) {
        
        long[] result = new long[3];
        long a = num / 3;
        if (num % 3 == 0) {
            result[0] = a - 1;
            result[1] = a;
            result[2] = a + 1;
        } else if (num % 3 == 1) {
            result[0] = a - 1;
            result[1] = a;
            result[2] = a + 2;
        } else {
            result[0] = a;
            result[1] = a + 1;
            result[2] = a + 2;
        }
        return result;
    }
}