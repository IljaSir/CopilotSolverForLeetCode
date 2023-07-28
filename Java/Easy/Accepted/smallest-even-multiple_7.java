class Solution {
    public int smallestEvenMultiple(int n) {
        
        int result = n;
        while(true) {
            if(result % 2 == 0) {
                return result;
            }
            result += n;
        }
    }
}