class Solution {
    public long[] sumOfThree(long num) {
        
        
        long[] res = new long[3];
        for (int i = 0; i < 3; i++) {
            res[i] = num - i;
        }
        return res;
    }
}