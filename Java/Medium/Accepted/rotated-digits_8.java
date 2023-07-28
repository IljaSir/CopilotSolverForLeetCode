class Solution {
    public int rotatedDigits(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            int digit = 0;
            boolean isGood = false;
            while (temp > 0) {
                digit = temp % 10;
                if (digit == 3 || digit == 4 || digit == 7) {
                    isGood = false;
                    break;
                } else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    isGood = true;
                }
                temp /= 10;
            }
            if (isGood) {
                count++;
            }
        }
        return count;
    }
}