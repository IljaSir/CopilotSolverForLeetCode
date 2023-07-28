class Solution {
    public int countOperations(int num1, int num2) {
        
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        int count = 0;
        while (max > 0) {
            count += max / min;
            int mod = max % min;
            max = min;
            min = mod;
        }
        return count - 1;
    }
}