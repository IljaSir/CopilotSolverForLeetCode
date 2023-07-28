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
        Set<Integer> set = new HashSet<>();
        while (n > 0) {
            int digit = n % 10;
            if (set.contains(digit)) {
                return false;
            }
            set.add(digit);
            n /= 10;
        }
        return true;
    }
}