class Solution {
    public int countSpecialNumbers(int n) {
        
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(isSpecial(i)) count++;
        }
        return count;
    }
    
    public boolean isSpecial(int n) {
        boolean[] seen = new boolean[10];
        while(n > 0) {
            int digit = n % 10;
            if(seen[digit]) return false;
            seen[digit] = true;
            n /= 10;
        }
        return true;
    }
}