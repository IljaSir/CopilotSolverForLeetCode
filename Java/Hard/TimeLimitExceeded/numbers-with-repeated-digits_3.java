class Solution {
    public int numDupDigitsAtMostN(int n) {
        
        int count = 0;
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            if (hasRepeatedDigit(i)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean hasRepeatedDigit(int n) {
        Set<Integer> set = new HashSet<>();
        while (n > 0) {
            int digit = n % 10;
            if (set.contains(digit)) {
                return true;
            } else {
                set.add(digit);
            }
            n /= 10;
        }
        return false;
    }
}