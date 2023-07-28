class Solution {
    public int minimumNumbers(int num, int k) {
        
        if (num < k) {
            return -1;
        }
        if (num == k) {
            return 1;
        }
        if (num % 9 == k) {
            return num / 9;
        }
        if ((num - k) % 9 == 0) {
            return (num - k) / 9 + 1;
        }
        return -1;
    }
}