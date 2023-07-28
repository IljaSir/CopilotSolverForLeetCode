class Solution {
    public int[] countBits(int n) {
        
        int[] result = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            result[i] = count(i);
        }
        return result;
    }
    
    private int count(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}