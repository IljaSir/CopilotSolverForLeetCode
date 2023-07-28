class Solution {
    public long[] sumOfThree(long num) {
        
        long[] res = new long[3];
        long n = num - 6;
        if (n > 0 && n % 3 == 0) {
            res[0] = n / 3;
            res[1] = res[0] + 1;
            res[2] = res[1] + 1;
        }
        return res;
    }
}