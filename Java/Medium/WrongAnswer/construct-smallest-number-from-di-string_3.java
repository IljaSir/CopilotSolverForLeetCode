class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int[] nums = new int[n + 1];
        int min = 0;
        int max = n;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                nums[i] = min;
                min++;
            } else {
                nums[i] = max;
                max--;
            }
        }
        nums[n] = min;
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}