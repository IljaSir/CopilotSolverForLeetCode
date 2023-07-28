class Solution {
    public int countDistinctIntegers(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(reverse(n));
        }
        return set.size();
    }
    
    private int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
}