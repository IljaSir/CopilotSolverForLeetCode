class Solution {
    public int minOperations(int n) {
        
        int count = 0;
        while (n > 0) {
            n = n >> 1;
            count++;
        }
        return count - 1;
    }
}