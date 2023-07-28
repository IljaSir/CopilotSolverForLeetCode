class Solution {
    public int countSpecialNumbers(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isSpecial(int n) {
        boolean[] seen = new boolean[10];
        while (n > 0) {
            int d = n % 10;
            if (seen[d]) {
                return false;
            }
            seen[d] = true;
            n /= 10;
        }
        return true;
    }
}