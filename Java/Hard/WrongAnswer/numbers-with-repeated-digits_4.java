class Solution {
    public int numDupDigitsAtMostN(int n) {
        
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (hasRepeat(i)) {
                res++;
            }
        }
        return res;
    }
    
    private boolean hasRepeat(int n) {
        Set<Integer> set = new HashSet<>();
        while (n > 0) {
            int rem = n % 10;
            if (set.contains(rem)) {
                return true;
            }
            set.add(rem);
            n /= 10;
        }
        return false;
    }
}