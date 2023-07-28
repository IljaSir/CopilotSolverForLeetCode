class Solution {
    public int countDistinctIntegers(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int rev = reverse(num);
            set.add(rev);
        }
        return set.size();
    }

    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}