class Solution {
    public int countSpecialNumbers(int n) {
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean isSpecial(int num) {
        Set<Integer> set = new HashSet<>();
        while (num > 0) {
            int digit = num % 10;
            if (set.contains(digit)) {
                return false;
            }
            set.add(digit);
            num /= 10;
        }
        return true;
    }
}