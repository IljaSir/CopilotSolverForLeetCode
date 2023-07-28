class Solution {
    public long[] sumOfThree(long num) {
        
        long[] result = new long[3];
        if (num < 3) {
            return new long[0];
        }
        if (num % 3 == 0) {
            result[0] = num / 3 - 1;
            result[1] = num / 3;
            result[2] = num / 3 + 1;
        } else if (num % 3 == 1) {
            result[0] = num / 3 - 1;
            result[1] = num / 3;
            result[2] = num / 3 + 1;
        } else {
            result[0] = num / 3;
            result[1] = num / 3 + 1;
            result[2] = num / 3 + 2;
        }
        return result;
    }
}