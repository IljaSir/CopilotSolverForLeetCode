class Solution {
    public long[] sumOfThree(long num) {
        
        long[] res = new long[3];
        long a = (num - 1) / 3;
        long b = (num - 2) / 3;
        long c = (num - 3) / 3;
        if (a * 3 + 1 == num) {
            res[0] = a;
            res[1] = a + 1;
            res[2] = a + 2;
            return res;
        }
        if (b * 3 + 2 == num) {
            res[0] = b;
            res[1] = b + 1;
            res[2] = b + 2;
            return res;
        }
        if (c * 3 + 3 == num) {
            res[0] = c;
            res[1] = c + 1;
            res[2] = c + 2;
            return res;
        }
        return new long[0];
    }
}