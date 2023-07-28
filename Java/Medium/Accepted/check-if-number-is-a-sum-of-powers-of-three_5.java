class Solution {
    public boolean checkPowersOfThree(int n) {
        
        int base = 1;
        while (n > 0) {
            if (n % 3 > 1) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}