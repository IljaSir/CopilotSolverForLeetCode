class Solution {
    public int smallestEvenMultiple(int n) {
        
        int result = n;
        while (result % 2 != 0) {
            result += n;
        }
        return result;
    }
}