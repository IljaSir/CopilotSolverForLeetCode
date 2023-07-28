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
    
    private boolean isSpecial(int num) {
        Set<Integer> digits = new HashSet<>();
        while (num > 0) {
            int digit = num % 10;
            if (digits.contains(digit)) {
                return false;
            }
            digits.add(digit);
            num /= 10;
        }
        return true;
    }
}