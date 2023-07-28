class Solution {
    public int getLucky(String s, int k) {
        
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - 'a' + 1;
        }
        String str = "";
        for (int n : nums) {
            str += n;
        }
        int sum = 0;
        while (k > 0) {
            sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Character.getNumericValue(str.charAt(i));
            }
            str = String.valueOf(sum);
            k--;
        }
        return sum;
    }
}