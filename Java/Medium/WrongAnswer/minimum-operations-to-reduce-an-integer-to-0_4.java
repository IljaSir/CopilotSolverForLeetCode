class Solution {
    public int minOperations(int n) {
        
        int result = 0;
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                result += Math.pow(2, i);
            }
            i++;
            n = n >> 1;
        }
        return result;
    }
}